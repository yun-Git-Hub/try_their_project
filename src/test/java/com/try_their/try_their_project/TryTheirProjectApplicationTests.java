package com.try_their.try_their_project;

import com.github.crab2died.ExcelUtils;
import com.try_their.try_their_project.entity.BookList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TryTheirProjectApplicationTests {
    public static void main(String[] args) throws Exception {
       //testObject2Excel();
       excel2Object2();
    }
    @Test
    void contextLoads() {
    }
    @Test
    public static void excel2Object2() throws Exception {
        String path = "E:/B.xlsx";
        // 基于注解,将Excel内容读至List对象内
        List<BookList> bookList = ExcelUtils.getInstance().readExcel2Objects(path, BookList.class, 0);
        System.out.println("读取Excel至对象数组(支持类型转换)：");
        for (BookList st : bookList) {
            System.out.println(st.getB_userID());
        }
    }
    @Test
    public static void testObject2Excel() throws Exception {
        String str = "2018-05-06 10:30:40";
        Timestamp time = Timestamp.valueOf(str);
            System.out.println(time);
            List<BookList> list = new ArrayList<>();
            list.add(new BookList(1, "遮天", "辰东",1,time));
            // 不基于模板导出Excel
            ExcelUtils.getInstance().exportObjects2Excel(list, BookList.class, true, null, true, "E:/B.xlsx");

    }
}
