package com.try_their.try_their_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class page {
    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 注册界面
     * @return
     */
    @RequestMapping("/user_reg")
    public String user_reg(){
        return "user_reg";
    }

    /**
     * 登录成功界面
     * @return
     */
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
