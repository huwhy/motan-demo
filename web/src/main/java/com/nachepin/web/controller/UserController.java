package com.nachepin.web.controller;

import com.nachepin.api.model.User;
import com.nachepin.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/showUser")
    public String toIndex(int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "hello";
    }
}
