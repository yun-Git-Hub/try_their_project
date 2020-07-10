package com.try_their.try_their_project.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.try_their.try_their_project.entity.BookList;
import com.try_their.try_their_project.entity.UserInfo;
import com.try_their.try_their_project.services.BookListServices;
import com.try_their.try_their_project.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.try_their.try_their_project.util.excelUtil.ExcelTool.excel2Object2;

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
     * 分页查询全部信息
     * @param model
     * @param session
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping("/sideTwoPage")
    public Map<String,Object> selectAll(Model model,HttpSession session,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        int user_id = getUser_id(session);
        //设置分页，页码 ，每页显示数据条数
        PageHelper.startPage(pageNum,3);
        /**
         * 根据当前用户user_id查询当前用户的全部书单信息并放入arrayList
         */
        ArrayList<BookList> bookLists = bookListServices.bookInfoAll(user_id);
        //新建pageInfo实现查询结果分页
        PageInfo<BookList> pageInfo = new PageInfo<BookList>(bookLists);
        /*model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("bookLists",bookLists);*/
        //System.out.println(pageNum);
        //存放bookLists 、pageInfo 返回map
        Map<String,Object> bookPage = new HashMap<>();
        bookPage.put("bookList",bookLists);
        bookPage.put("pageInfo",pageInfo);
        return bookPage;
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
    @ResponseBody
    @RequestMapping("/excelUpload")
    public String excelUpload(@RequestParam("file") MultipartFile file,HttpSession session) throws Exception {
        int user_id = getUser_id(session);//当前用户ID
        //文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName= fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffixName);
        if(suffixName==".xlsx"||suffixName.equals(".xlsx")){
            String excelPath="E:\\Code-GitHub\\try_their_project\\src\\main\\resources\\excelFile\\";
            //拼接完整的路径
            String path=excelPath+fileName;
            System.out.println(path);
            //文件对象
            File dest=new File(path);
            System.out.println(dest);
            //检测文件路径是否存在，如果不存在则新建文件，存在直接写入文件
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            //文件写入
            file.transferTo(dest);
            int i=0;
            List<BookList> bookLists = excel2Object2(path);
            for (BookList bl : bookLists) {
                bl.setB_userID(user_id);
                i = bookListServices.insertBookInfo(bl);
                if (i==0){
                    break;
                }
            }
            if(i!=0){
                dest.delete();//删除上传的excel
                return "true";
            }
        }
            return "false";
    }
    @ResponseBody
    @RequestMapping("/excelDown")
    public String excelDown(){
        return "";
    }
}
