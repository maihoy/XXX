package com.makarevich.controller;

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
import com.makarevich.model.Team;
import com.makarevich.service.TeamService;

@Controller
@RequestMapping("/")

public class IndexController {

    @Autowired
    TeamService service;

    @RequestMapping(value = { "/team" }, method = RequestMethod.GET)
    public String listTeams(ModelMap model) {

        List<Team> teams = service.findAllTeams();
        model.addAttribute("teams", teams);
        return "team/list";
    }
}
