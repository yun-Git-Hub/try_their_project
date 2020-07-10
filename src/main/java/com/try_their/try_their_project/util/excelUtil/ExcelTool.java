package com.try_their.try_their_project.util.excelUtil;

import com.github.crab2died.ExcelUtils;
import com.try_their.try_their_project.entity.BookList;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExcelTool {
    /**
     * 导入
     * @param path
     * @throws Exception
     */
    public static List<BookList> excel2Object2(String path) throws Exception {
        // 基于注解,将Excel内容读至List对象内
        List<BookList> bookList = ExcelUtils.getInstance().readExcel2Objects(path, BookList.class, 0);
        /*System.out.println("读取Excel至对象数组(支持类型转换)：");
        for (BookList st : bookList) {
            System.out.println(st.getB_userID());
        }*/
        return bookList;
    }
    public static void testObject2Excel(List<BookList> list,String path) throws Exception {
        /*String str = "2018-05-06 10:30:40";
        Timestamp time = Timestamp.valueOf(str);
        System.out.println(time);
        List<BookList> list = new ArrayList<>();
        list.add(new BookList(1, "遮天", "辰东",1,time));*/

        //检测文件路径是否存在，如果不存在则新建文件，存在直接写入文件
        File dest = new File(path);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        // 不基于模板导出Excel
        ExcelUtils.getInstance().exportObjects2Excel(list, BookList.class, true, null, true, path);
    }
}
