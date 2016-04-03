package com.makarevich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/xdrctfuvg")

public class IndexController {


   @RequestMapping(value = { "/cfgvbh" }, method = RequestMethod.GET)
    public String index() {
        return "home";
    }
}
