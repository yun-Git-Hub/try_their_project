package com.try_their.try_their_project.util.shiro;

import com.try_their.try_their_project.entity.UserInfo;
import com.try_their.try_their_project.services.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import static com.try_their.try_their_project.util.md5.MD5Util.getMD5Digest;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService infoService;
    /**
     * 授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /**
        * 获取token 获取username 验证用户
        */
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_name(token.getUsername());
        UserInfo info = infoService.userLogin(userInfo);
        if(info==null){
            userInfo.setUserPhone(token.getUsername());
            info =infoService.userLogin(userInfo);
        }

        /**
         *从token中获取密码，password，
         * 从数据库中获取salt值
         * password+salt 进行MD5加密，
         * 将加密后的密码，toCharArray()之后，重新给token
        */
        String pwd =String.valueOf(token.getPassword());
        /*System.out.println(pwd);
        System.out.println(info.getMd5_pwd());*/
        String s = getMD5Digest(pwd + info.getMd5_pwd());
        token.setPassword(s.toCharArray());

        return new SimpleAuthenticationInfo("",info.getUser_password(),"");
    }
}
