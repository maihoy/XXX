package com.makarevich.controller.player;
import com.makarevich.service.front.player.PlayerService;
import com.makarevich.service.front.player.dto.PlayerDTO;
import com.makarevich.service.front.team.TeamService;
import com.makarevich.service.front.team.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    PlayerService service;

    @Autowired
    TeamService teamService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listPlayer(ModelMap model) {

        List<PlayerDTO> players = service.findAllPlayers();
        model.addAttribute("players", players);
        return "player/list";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newPlayer(ModelMap model) {
        PlayerDTO player = new PlayerDTO();
        model.addAttribute("player", player);
        model.addAttribute("edit", false);
        return "player/manage";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String savePlayer(@Valid @ModelAttribute("player") PlayerDTO player, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "player/manage";
        }


        service.savePlayer(player);
        return "redirect:/player/list";
    }



    @RequestMapping(value = { "/edit-{id}-player" }, method = RequestMethod.GET)
    public String editPlayer(@PathVariable Long id, ModelMap model) {
        PlayerDTO player = service.findById(id);
        model.addAttribute("player", player);
        model.addAttribute("edit", true);
        return "player/manage";
    }


    @RequestMapping(value = { "/edit-{id}-player" }, method = RequestMethod.POST)
    public String updatePlayer(@Valid @ModelAttribute("player") PlayerDTO player, BindingResult result,
                             ModelMap model, @PathVariable Long id) {

        if (result.hasErrors()) {
            return "player/manage";
        }


        service.updatePlayer(player);
        return "redirect:/player/list";
    }


    @RequestMapping(value = { "/delete-{id}-player" }, method = RequestMethod.GET)
    public String deletePlayer(@PathVariable Long id) {
        service.deletePlayerById(id);
        return "redirect:/player/list";
    }

   @ModelAttribute("teams")
    public  List<TeamDTO> initializeProfiles(){
        return teamService.findAllTeams();
    }

}