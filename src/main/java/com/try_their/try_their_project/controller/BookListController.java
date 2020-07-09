package com.try_their.try_their_project.controller;


import com.try_their.try_their_project.entity.BookList;
import com.try_their.try_their_project.entity.UserInfo;
import com.try_their.try_their_project.services.BookListServices;
import com.try_their.try_their_project.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class BookListController {
    @Autowired
    private BookListServices bookListServices;
    @Autowired
    private UserInfoService infoService;
    /**
     * 获取当前用户user_id
     */
    public int getUser_id(HttpSession session){
        String userName = (String)session.getAttribute("userName");
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_name(userName);
        UserInfo info = infoService.userLogin(userInfo);
        return info.getUser_id();
    }

    /**
     * 查询全部信息
     * @param model
     * @return
     */
    @RequestMapping("/sideTwo")
    public String selectAll(Model model,HttpSession session){
        int user_id = getUser_id(session);
        /**
         * 根据当前用户user_id查询当前用户的全部书单信息并放入arrayList
         */
        ArrayList<BookList> bookLists = bookListServices.bookInfoAll(user_id);
        model.addAttribute("bookLists",bookLists);
        return "sideTwo";
    }

    /**
     * 添加新的book Info
     * @param bookList
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/insertBookInfo")
    public String insertBookInfo(BookList bookList,HttpSession session){
        if(bookList!=null){
            int user_id = getUser_id(session);
            bookList.setB_userID(user_id);
            int i = bookListServices.insertBookInfo(bookList);
            if(i!=0){
                return "true";
            }else{
                return "false";
            }
        }
        return "false";
    }
}
