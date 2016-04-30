package com.makarevich.controller.comment;


import com.makarevich.service.front.comment.CommentService;
import com.makarevich.service.front.comment.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/comment")

public class CommentController {

    @Autowired
    CommentService service;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listComments(ModelMap model) {

        List<CommentDTO> comments = service.findAllComments();
        model.addAttribute("comments", comments);
        return "comment/list";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newComment(ModelMap model) {
        CommentDTO comment = new CommentDTO();
        model.addAttribute("comment", comment);
        model.addAttribute("edit", false);
        return "comment/manage";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveComment(@Valid @ModelAttribute("comment") CommentDTO comment, BindingResult result,
                              ModelMap model) {

        if (result.hasErrors()) {
            return "comment/manage";
        }


        service.saveComment(comment);
        return "redirect:/comment/list";
    }



    @RequestMapping(value = { "/edit-{id}-comment" }, method = RequestMethod.GET)
    public String editComment(@PathVariable Long id, ModelMap model) {
        CommentDTO comment = service.findById(id);
        model.addAttribute("comment", comment);
        model.addAttribute("edit", true);
        return "comment/manage";
    }


    @RequestMapping(value = { "/edit-{id}-comment" }, method = RequestMethod.POST)
    public String updateComment(@Valid @ModelAttribute("comment") CommentDTO comment, BindingResult result,
                             ModelMap model, @PathVariable Long id) {

        if (result.hasErrors()) {
            return "comment/manage";
        }


        service.updateComment(comment);
        return "redirect:/comment/list";
    }


    @RequestMapping(value = { "/delete-{id}-comment" }, method = RequestMethod.GET)
    public String deleteComment(@PathVariable Long id) {
        service.deleteCommentById(id);
        return "redirect:/comment/list";
    }
}
