package com.makarevich.controller;

import com.makarevich.model.Comment;
import com.makarevich.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/comment")

public class CommentController  {

    @Autowired
    CommentService service;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listComments(ModelMap model) {

        List<Comment> comments = service.findAllComments();
        model.addAttribute("comments", comments);
        return "comment/list";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newComment(ModelMap model) {
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        model.addAttribute("edit", false);
        return "comment/create";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveComment(@Valid Comment comment, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "comment/create";
        }


        service.saveComment(comment);
        return "redirect:/comment/list";
    }



    @RequestMapping(value = { "/edit-{id}-comment" }, method = RequestMethod.GET)
    public String editComment(@PathVariable int id, ModelMap model) {
        Comment comment = service.findById(id);
        model.addAttribute("comment", comment);
        model.addAttribute("edit", true);
        return "comment/create";
    }


    @RequestMapping(value = { "/edit-{id}-comment" }, method = RequestMethod.POST)
    public String updateComment(@Valid Comment comment, BindingResult result,
                             ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return "comment/create";
        }


        service.updateComment(comment);
        return "redirect:/comment/list";
    }


    @RequestMapping(value = { "/delete-{id}-comment" }, method = RequestMethod.GET)
    public String deleteComment(@PathVariable int id) {
        service.deleteCommentById(id);
        return "redirect:/comment/list";
    }

}
