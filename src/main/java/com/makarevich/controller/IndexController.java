package com.makarevich.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;
import java.util.List;
import com.makarevich.model.Team;
import com.makarevich.service.TeamService;

@Controller
@RequestMapping("/")

public class IndexController {
    @Autowired
    TeamService service;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listTeams(ModelMap model) {

        List<Team> teams = service.findAllTeams();
        model.addAttribute("teams", teams);
        return "allteams";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newTeam(ModelMap model) {
        Team team = new Team();
        model.addAttribute("team", team);
        model.addAttribute("edit", false);
        return "registration";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveTeam(@Valid Team team, BindingResult result,
                               ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation
         * and applying it on field [ssn] of Model class [Team].
         *
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         *
         */


        service.saveTeam(team);

        model.addAttribute("success", "Team " + team.getName() + " registered successfully");
        return "success";
    }



    @RequestMapping(value = { "/edit-{id}-team" }, method = RequestMethod.GET)
    public String editTeam(@PathVariable int id, ModelMap model) {
        Team team = service.findById(id);
        model.addAttribute("team", team);
        model.addAttribute("edit", true);
        return "registration";
    }


    @RequestMapping(value = { "/edit-{id}-team" }, method = RequestMethod.POST)
    public String updateTeam(@Valid Team team, BindingResult result,
                                 ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return "registration";
        }


        service.updateTeam(team);

        model.addAttribute("success", "Team " + team.getName()  + " updated successfully");
        return "success";
    }


    @RequestMapping(value = { "/delete-{id}-team" }, method = RequestMethod.GET)
    public String deleteTeam(@PathVariable int id) {
        service.deleteTeamById(id);
        return "redirect:/list";
    }
}
