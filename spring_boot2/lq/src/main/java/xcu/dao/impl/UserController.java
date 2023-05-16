package xcu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import xcu.dao.UserService;
import xcu.entity.User;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public void findUser(){
        User user = userService.findUserById(1l);
        System.out.println(user);
    }
}
