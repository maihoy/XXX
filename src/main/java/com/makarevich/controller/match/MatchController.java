package com.makarevich.controller.match;

import com.makarevich.controller.IndexController;
import com.makarevich.service.front.player.PlayerService;
import com.makarevich.service.front.player.dto.PlayerDTO;
import com.makarevich.service.front.team.TeamService;
import com.makarevich.service.front.team.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/match")
public class MatchController extends IndexController {

        @Autowired
        PlayerService playerService;

        @Autowired
        TeamService teamService;

        @Autowired
        MessageSource messageSource;


    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String listPlayer(ModelMap model) {

        List<TeamDTO> teams = teamService.findAllTeams();
        model.addAttribute("teams", teams);
        model.addAttribute("user",getPrincipal());
        return "match/manage";
    }

        @ModelAttribute("teams")
        public List<TeamDTO> initializeProfiles(){
            return teamService.findAllTeams();
        }


}
