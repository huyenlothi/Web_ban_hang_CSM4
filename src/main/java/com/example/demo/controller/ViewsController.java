package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewsController {
    @GetMapping("/")
    public ModelAndView show() {
        return new ModelAndView("index");
    }

    @GetMapping("/1")
    public ModelAndView show1() {
        return new ModelAndView("checkout");
    }

    @GetMapping("/2")
    public ModelAndView show2() {
        return new ModelAndView("product/list");
    }

    @GetMapping("/dcm")
    public ModelAndView show3() {
        return new ModelAndView("product/create");
    }
}
