package com.try_their.try_their_project.controller;

import com.try_their.try_their_project.entity.UserInfo;
import com.try_their.try_their_project.services.UserInfoService;
import com.try_their.try_their_project.util.md5.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static com.try_their.try_their_project.util.md5.MD5Util.getMD5Digest;

@Controller
public class LoginController {
    @Autowired
    private UserInfoService infoService;

    UsernamePasswordToken token = null;
    Subject subject =null;

    /**
     * 注册 密码进行md5加盐处理
     * @param userInfo
     * @return
     */
    @RequestMapping("/reg_user")
    public String reg_user(UserInfo userInfo){
        String password = userInfo.getUser_password();
        //获取随机盐值
        String salt = MD5Util.getSalt(4);
        //密码加盐 MD5加密
        String pwd = getMD5Digest(password + salt);
        userInfo.setMd5_pwd(salt);
        userInfo.setUser_password(pwd);
        infoService.userAdd(userInfo);
        return "/index";
    }

    /**
     * 登录
     * @param userInfo
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user_login")
    public String user_login(UserInfo userInfo, Model model, HttpSession session){
        subject = SecurityUtils.getSubject();
        String userPhone = userInfo.getUserPhone();
        String userName = userInfo.getUser_name();
        String userPassword = userInfo.getUser_password();
        /*两种登录情况
        * 用户名登录和手机登录*/
        if(userInfo.getUser_name()==null){
            token = new UsernamePasswordToken(userPhone,userPassword);
        }else{
            token = new UsernamePasswordToken(userName,userPassword);
        }
        try {
            subject.login(token);
            //model.addAttribute("userName",userInfo.getUser_name());
            session.setAttribute("userName",userInfo.getUser_name());
            return "redirect:book_list";
        }catch (UnknownAccountException U){
            U.printStackTrace();
            return "index";
        } catch (IncorrectCredentialsException I){
            return "index";
        }
    }


    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String delToken(HttpSession session){
        try {
            subject.logout();
            session.removeAttribute("userName");
            return "redirect:index";
        }catch (SessionException e){
            e.printStackTrace();
        }
        return "redirect:index";
    }

    /**
     * 用户个人信息 userName，userTime
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/sideOne")
    public String selectInfo(HttpSession session,Model model){
        String userName = (String)session.getAttribute("userName");
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_name(userName);
        UserInfo info = infoService.userLogin(userInfo);
        model.addAttribute("info",info);
        return "sideOne";
    }


}
