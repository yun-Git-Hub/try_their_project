package com.try_their.try_their_project.entity;

import java.sql.Timestamp;

public class BookList {
    private int b_id;
    private String b_name;
    private String b_author;
    private Timestamp b_time;

    public BookList() {
    }

    public BookList(int b_id, String b_name, String b_author, Timestamp b_time) {
        this.b_id = b_id;
        this.b_name = b_name;
        this.b_author = b_author;
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

    public Timestamp getB_time() {
        return b_time;
    }

    public void setB_time(Timestamp b_time) {
        this.b_time = b_time;
    }
}
