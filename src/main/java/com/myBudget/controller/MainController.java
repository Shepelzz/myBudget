package com.myBudget.controller;

import com.myBudget.exception.BadRequestException;
import com.myBudget.model.RegisterForm;
import com.myBudget.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Log4j
@Controller
public class MainController {
    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = {"/", "/login", "/index"}, method = RequestMethod.GET)
    public String mainPage(Model model, HttpSession session){
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

    @RequestMapping(path = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody RegisterForm registerForm){
        if(userService.save(registerForm) == null)
            throw new BadRequestException("registration error");

        return "redirect:/";
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test(Model model, HttpSession session){
        return "test";
    }

    @RequestMapping(path = "/qq", method = RequestMethod.GET)
    public String q(Model model, HttpSession session){
        return "qq";
    }


    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        return "home";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model, HttpSession session){
        return "register";
    }

    @RequestMapping(path = "/forgot-password", method = RequestMethod.GET)
    public String forgotPassword(Model model, HttpSession session){
        return "forgot-password";
    }

    @RequestMapping(path = "/category-type", method = RequestMethod.GET)
    public String categoryType(Model model, HttpSession session){
        return "category-type";
    }

    @RequestMapping(path = "/category", method = RequestMethod.GET)
    public String category(Model model, HttpSession session){
        return "category";
    }


}
