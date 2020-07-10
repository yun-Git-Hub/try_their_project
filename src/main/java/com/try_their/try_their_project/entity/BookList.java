package com.try_their.try_their_project.entity;

import com.github.crab2died.annotation.ExcelField;

import java.sql.Timestamp;

public class BookList {
    /*@ExcelField(title = "存储序号",order = 1)*/
    private int b_id;
    @ExcelField(title = "书籍名称",order = 2)
    private String b_name;
    @ExcelField(title = "书籍作者",order = 3)
    private String b_author;
    /*@ExcelField(title = "用户ID",order = 4)*/
    private int b_userID;
    /*@ExcelField(title = "存储时间",order = 5)*/
    private Timestamp b_time;

    public BookList() {
    }

    public BookList(int b_id, String b_name, String b_author, int b_userID, Timestamp b_time) {
        this.b_id = b_id;
        this.b_name = b_name;
        this.b_author = b_author;
        this.b_userID = b_userID;
        this.b_time = b_time;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_author() {
        return b_author;
    }

    public void setB_author(String b_author) {
        this.b_author = b_author;
    }

    public int getB_userID() {
        return b_userID;
    }

    public void setB_userID(int b_userID) {
        this.b_userID = b_userID;
    }

    public Timestamp getB_time() {
        return b_time;
    }

    public void setB_time(Timestamp b_time) {
        this.b_time = b_time;
    }
}
