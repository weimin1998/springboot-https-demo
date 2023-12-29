package com.example.springboothttpsdemo.demos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello https";
    }

}
