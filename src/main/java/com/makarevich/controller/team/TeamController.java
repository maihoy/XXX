package com.makarevich.controller.team;


import com.makarevich.service.front.team.dto.TeamDTO;
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
import com.makarevich.service.front.team.TeamService;

@Controller
@RequestMapping("/team")

public class TeamController {
    @Autowired
    TeamService service;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listTeams(ModelMap model) {

        List<TeamDTO> teams = service.findAllTeams();
        model.addAttribute("teams", teams);
        return "team/list";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newTeam(ModelMap model) {
        TeamDTO team = new TeamDTO();
        model.addAttribute("team", team);
        model.addAttribute("edit", false);
        return "team/manage";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveTeam(@Valid TeamDTO team, BindingResult result,
                               ModelMap model) {

        if (result.hasErrors()) {
            return "team/manage";
        }


        service.saveTeam(team);
        return "redirect:/team/list";
    }



    @RequestMapping(value = { "/edit-{id}-team" }, method = RequestMethod.GET)
    public String editTeam(@PathVariable Long id, ModelMap model) {
        TeamDTO team = service.findById(id);
        model.addAttribute("team", team);
        model.addAttribute("edit", true);
        return "team/manage";
    }


    @RequestMapping(value = { "/edit-{id}-team" }, method = RequestMethod.POST)
    public String updateTeam(@Valid TeamDTO team, BindingResult result,
                                 ModelMap model, @PathVariable Long id) {

        if (result.hasErrors()) {
            return "team/manage";
        }


        service.updateTeam(team);
        return "redirect:/team/list";
    }


    @RequestMapping(value = { "/delete-{id}-team" }, method = RequestMethod.GET)
    public String deleteTeam(@PathVariable Long id) {
        service.deleteTeamById(id);
        return "redirect:/team/list";
    }
}
