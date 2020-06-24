package com.try_their.try_their_project.services;

import com.try_their.try_their_project.entity.UserInfo;

public interface UserInfoService {
    public void userAdd(UserInfo userInfo);//添加用户
    public UserInfo userLogin(UserInfo userInfo);//用户登录
}
