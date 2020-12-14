package com.assignment.towerofhanoi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Sophia Klocheva
 * on 14/12/2020
 */
@Controller
public class HomeController
{
    @GetMapping("/home")
    public String home()
    {
        return "home";
    }
}
