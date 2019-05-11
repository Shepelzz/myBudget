package com.myBudget.api;


import com.myBudget.entity.User;
import com.myBudget.exception.BadRequestException;
import com.myBudget.model.AuthForm;
import com.myBudget.model.RegisterForm;
import com.myBudget.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;

@RestController
@Log4j
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpStatus login(HttpSession session, @RequestBody AuthForm authForm){
        User user = userService.login(authForm.getLogin(), authForm.getPassword());
        if(user == null)
            throw new BadRequestException("wrong login or password");

        log.info("User with id:"+user.getId()+" logged in");
        session.setAttribute("loggedUser", user);
        session.setAttribute("loggedUserId", String.valueOf(user.getId()));
        session.setAttribute("loggedUserName", user.getFirstName()+" "+user.getLastName());

        return HttpStatus.OK;
    }

//    @RequestMapping(path = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public String saveCategoryType(@RequestBody RegisterForm registerForm){
//        if(userService.save(registerForm) == null)
//            throw new BadRequestException("registration error");
//
//        return "redirect:/";
//    }

}
