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
    @RequestMapping("/sidebar")
    public String success(){
        return "sidebar";
    }
    /**
     */
    @RequestMapping("/book_list")
    public String book_list(){
        return "book_list";
    }
    @RequestMapping("/sideTwo")
    public String sideTwo(){
        return "sideTwo";
    }
    @RequestMapping("/sideThree")
    public String sideThree(){
        return "sideThree";
    }
    @RequestMapping("/sideUpload")
    public String sideUpload(){
        return "sideUpload";
    }
    @RequestMapping("/sideDown")
    public String sideDown(){
        return "sideDown";
    }
}
