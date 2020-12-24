package cn.xiaojianbang.controller;

import cn.xiaojianbang.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lf on 2020/12/24
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private User user;


    @GetMapping("1")
    public String getUserById(){
        return user.toString();
    }
}
