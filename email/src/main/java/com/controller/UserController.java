package com.controller;



import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.UserService;


import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(User user, HttpSession session){
        User u =userService.login(user);
        if(u!=null){
            session.setAttribute("u",u);
            return "index";
        }else {
            return "redirect:/login.jsp";
        }

    }
}
