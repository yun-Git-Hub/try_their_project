package com.try_their.try_their_project.services.impl;

import com.try_their.try_their_project.dao.BookListDao;
import com.try_their.try_their_project.entity.BookList;
import com.try_their.try_their_project.services.BookListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class BookListImpl implements BookListServices {
    @Autowired(required = false)
    private BookListDao bookListDao;

    @Override
    public ArrayList<BookList> bookInfoAll(int userID) {
        ArrayList<BookList> bookLists = bookListDao.bookInfoAll(userID);
        return bookLists;
    }

    @Override
    public int insertBookInfo(BookList bookList) {
        int i = bookListDao.insertBookInfo(bookList);
        return i;
    }
}
