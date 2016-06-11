package com.makarevich.controller.user;

import com.makarevich.controller.IndexController;
import com.makarevich.service.front.user.UserService;
import com.makarevich.service.front.user.dto.UserDTO;
import com.makarevich.service.front.userrole.UserRoleService;
import com.makarevich.service.front.userrole.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController extends IndexController {

    @Autowired
    UserService service;

    @Autowired
    MessageSource messageSource;

    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<UserDTO> users = service.findAllUsers();
        model.addAttribute("user", users);
        model.addAttribute("currentUser",getPrincipal());
        return "user/list";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("currentUser",getPrincipal());
        return "user/newuser";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult result,
                              ModelMap model) {

        if (result.hasErrors()) {
            return "user/newuser";
        }


        service.save(user);
        return "redirect:/user/list";
    }



    @RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.GET)
    public String editUser(@PathVariable Long id, ModelMap model) {
        UserDTO user = service.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("currentUser",getPrincipal());
        return "user/newuser";
    }


    @RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.POST)
    public String updateUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult result,
                                ModelMap model, @PathVariable Long id) {

        if (result.hasErrors()) {
            return "user/newuser";
        }


        service.updateUser(user);
        return "redirect:/user/list";
    }


    @RequestMapping(value = { "/delete-{id}-user" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        service.deleteUserById(id);
        return "redirect:/user/list";
    }

    @ModelAttribute("roles")
    public List<UserRoleDTO> initializeProfiles() {
        return userRoleService.findAll();
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Set.class, "roles", new CustomCollectionEditor(Set.class) {
            @Override
            protected Object convertElement(Object element) {
                Long id = null;

                if (element instanceof String && !((String) element).equals("")) {
                    //From the JSP 'element' will be a String
                    try {
                        id = Long.parseLong((String) element);
                    } catch (NumberFormatException e) {
                        System.out.println("Element was " + ((String) element));
                        e.printStackTrace();
                    }
                } else if (element instanceof Long) {
                    //From the database 'element' will be a Long
                    id = (Long) element;
                }

                return id != null ? userRoleService.findById(id) : null;
            }
        });
    }


}
