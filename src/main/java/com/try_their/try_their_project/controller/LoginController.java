package com.try_their.try_their_project.controller;

import com.try_their.try_their_project.entity.UserInfo;
import com.try_their.try_their_project.services.UserInfoService;
import com.try_their.try_their_project.util.md5.MD5Util;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.try_their.try_their_project.util.md5.MD5Util.getMD5Digest;

@Controller
public class LoginController {
    @Autowired
    private UserInfoService infoService;

    UsernamePasswordToken token = null;
    Subject subject =null;
    @RequestMapping("/reg_user")
    public String reg_user(UserInfo userInfo){
        String password = userInfo.getUser_password();
        String salt = MD5Util.getSalt(4);
        String pwd = getMD5Digest(password + salt);
        userInfo.setMd5_pwd(salt);
        userInfo.setUser_password(pwd);
        infoService.userAdd(userInfo);
        return "/index";
    }

    @RequestMapping("/user_login")
    public String user_login(UserInfo userInfo){
        subject = SecurityUtils.getSubject();
        String userPhone = userInfo.getUserPhone();
        String userName = userInfo.getUser_name();
        String userPassword = userInfo.getUser_password();
        if(userInfo.getUser_name()==null){
            token = new UsernamePasswordToken(userPhone,userPassword);
        }else{
            token = new UsernamePasswordToken(userName,userPassword);
        }
        try {
            subject.login(token);
            return "success";
        }catch (UnknownAccountException U){
            U.printStackTrace();
            return "index";
        } catch (IncorrectCredentialsException I){
            return "index";
        }
    }


    @RequestMapping("/logout")
    public String delToken(){
        try {
            subject.logout();
        }catch (SessionException e){
            e.printStackTrace();
        }
        return "index";
    }
}
