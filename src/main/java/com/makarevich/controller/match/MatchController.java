package com.makarevich.controller.match;

import com.makarevich.controller.IndexController;
import com.makarevich.service.front.match.MatchService;
import com.makarevich.service.front.match.ScoreService;
import com.makarevich.service.front.match.dto.MatchDTO;
import com.makarevich.service.front.match.dto.ScoreDTO;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/match")
public class MatchController extends IndexController {

        @Autowired
        TeamService teamService;

    @Autowired
    ScoreService scoreService;

        @Autowired
        MessageSource messageSource;


    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listMatches(ModelMap model) {

        List<ScoreDTO> scores = scoreService.findAllScores();
        model.addAttribute("scores", scores);
        model.addAttribute("currentUser",getPrincipal());
        return "match/list";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newMatch(ModelMap model) {
        ScoreDTO score = new ScoreDTO();
        model.addAttribute("score", score);
        model.addAttribute("edit", false);
        model.addAttribute("currentUser",getPrincipal());
        return "match/manage";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveMatch(@Valid @ModelAttribute("score") ScoreDTO score, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "match/manage";
        }


        scoreService.saveScore(score);
        return "redirect:/match/list";
    }



    @RequestMapping(value = { "/edit-{id}-match" }, method = RequestMethod.GET)
    public String editMatch(@PathVariable Long id, ModelMap model) {
        ScoreDTO score = scoreService.findScoreById(id);
        model.addAttribute("score", score);
        model.addAttribute("edit", true);
        model.addAttribute("currentUser",getPrincipal());
        return "match/manage";
    }


    @RequestMapping(value = { "/edit-{id}-match" }, method = RequestMethod.POST)
    public String updateMatch(@Valid @ModelAttribute("score") ScoreDTO score, BindingResult result,
                             ModelMap model, @PathVariable Long id) {

        if (result.hasErrors()) {
            return "match/manage";
        }


        scoreService.updateScore(score);
        return "redirect:/match/list";
    }


    @RequestMapping(value = { "/delete-{id}-match" }, method = RequestMethod.GET)
    public String deleteMatch(@PathVariable Long id) {
        scoreService.deleteScoreById(id);
        return "redirect:/match/list";
    }


    @ModelAttribute("teams")
        public List<TeamDTO> initializeProfiles(){   return teamService.findAllTeams(); }


}
