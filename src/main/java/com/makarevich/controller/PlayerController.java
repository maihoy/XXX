package com.makarevich.controller;
import com.makarevich.model.Player;
import com.makarevich.service.PlayerService;
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
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    PlayerService service;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listPlayer(ModelMap model) {

        List<Player> players = service.findAllPlayers();
        model.addAttribute("players", players);
        return "player/list";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newPlayer(ModelMap model) {
        Player player = new Player();
        model.addAttribute("player", player);
        model.addAttribute("edit", false);
        return "player/manage";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String savePlayer(@Valid Player player, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "player/manage";
        }


        service.savePlayer(player);
        return "redirect:/player/list";
    }



    @RequestMapping(value = { "/edit-{id}-player" }, method = RequestMethod.GET)
    public String editPlayer(@PathVariable int id, ModelMap model) {
        Player player = service.findById(id);
        model.addAttribute("player", player);
        model.addAttribute("edit", true);
        return "player/manage";
    }


    @RequestMapping(value = { "/edit-{id}-player" }, method = RequestMethod.POST)
    public String updatePlayer(@Valid Player player, BindingResult result,
                             ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return "player/manage";
        }


        service.updatePlayer(player);
        return "redirect:/player/list";
    }


    @RequestMapping(value = { "/delete-{id}-player" }, method = RequestMethod.GET)
    public String deletePlayer(@PathVariable int id) {
        service.deletePlayerById(id);
        return "redirect:/player/list";
    }

}