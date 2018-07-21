package org.himalay.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DroppingPage {
    @RequestMapping("/")
    public String droppingPage(){
        return "index";
    }
}