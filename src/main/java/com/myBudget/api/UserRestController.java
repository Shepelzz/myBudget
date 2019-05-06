package com.myBudget.api;


import com.myBudget.entity.User;
import com.myBudget.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Log4j
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(HttpSession session, HttpServletRequest request){
        User user = userService.login(request.getParameter("email"), request.getParameter("password"));
        log.info("User with id:"+user.getId()+" logged in");

        session.setAttribute("loggedUser", user);
        session.setAttribute("loggedUserId", String.valueOf(user.getId()));
        session.setAttribute("loggedUserName", user.getFirstName()+" "+user.getLastName());

        return new ResponseEntity<>("redirect:/home", HttpStatus.OK);
    }

}
