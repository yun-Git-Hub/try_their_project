package com.try_their.try_their_project.controller;


import com.try_their.try_their_project.entity.BookList;
import com.try_their.try_their_project.services.BookListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class BookListController {
    @Autowired
    private BookListServices bookListServices;

    @RequestMapping("/sideTwo")
    public String selectAll(Model model){
        ArrayList<BookList> bookLists = bookListServices.bookInfoAll();
        model.addAttribute("bookLists",bookLists);
        return "sideTwo";
    }
}
