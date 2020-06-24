package com.try_their.try_their_project.dao;

import com.try_their.try_their_project.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao {
    public void userAdd(UserInfo userInfo);//添加用户
    public UserInfo userLogin(UserInfo userInfo);//用户登录
}
