package com.try_their.try_their_project.dao;

import com.try_their.try_their_project.entity.BookList;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface BookListDao {
    public ArrayList<BookList> bookInfoAll();
}
