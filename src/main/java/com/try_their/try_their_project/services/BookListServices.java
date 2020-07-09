package com.try_their.try_their_project.services;

import com.try_their.try_their_project.entity.BookList;

import java.util.ArrayList;

public interface BookListServices {
    public ArrayList<BookList> bookInfoAll(int userID);
    public int insertBookInfo(BookList bookList);//添加新的bookInfo
}
