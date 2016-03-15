package com.qwerty.controller;

import com.qwerty.domain.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
  @RequestMapping("hello/{player}")
    public Message message(@PathVariable String player){
      Message msg = new Message(player, "Hello"+player);
      return msg;
  }
}
