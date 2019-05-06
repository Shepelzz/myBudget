package com.myBudget.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Log4j
@Controller
public class MainController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        String loggedUserId = (String) session.getAttribute("loggedUserId");
        if(loggedUserId != null)
            return "redirect:/home";
        model.addAttribute("loggedUser", session.getAttribute("loggedUser"));
        return "index";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        log.info("User with id:"+session.getAttribute("loggedUserId")+" logged out");
        session.invalidate();

        return "redirect:/";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String test(Model model, HttpSession session){
        return "home";
    }

}
