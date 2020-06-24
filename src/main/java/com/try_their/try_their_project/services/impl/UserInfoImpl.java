package com.try_their.try_their_project.services.impl;

import com.try_their.try_their_project.dao.UserInfoDao;
import com.try_their.try_their_project.entity.UserInfo;
import com.try_their.try_their_project.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoImpl implements UserInfoService {
    @Autowired(required = false)
    private UserInfoDao userInfoDao;

    @Override
    public void userAdd(UserInfo userInfo) {
        userInfoDao.userAdd(userInfo);
    }

    @Override
    public UserInfo userLogin(UserInfo userInfo) {
        UserInfo info = userInfoDao.userLogin(userInfo);
        return info;
    }
}
