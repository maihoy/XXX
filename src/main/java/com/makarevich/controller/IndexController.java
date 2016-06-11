package com.makarevich.controller;


import com.makarevich.service.front.user.UserService;
import com.makarevich.service.front.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = { "/","home" }, method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("user",getPrincipal());
        return "home";
    }

    protected String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
            UserDTO user = userService.findByEmail(userName);
            userName= user.getFirstName()+' '+user.getLastName();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    protected Long getSignedId(){
        Long signedId = null;
        String usr = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            usr = ((UserDetails)principal).getUsername();
            UserDTO user = userService.findByEmail(usr);
            signedId= user.getId();
        } else {
            usr = principal.toString();
        }
        return signedId;
    }



}
