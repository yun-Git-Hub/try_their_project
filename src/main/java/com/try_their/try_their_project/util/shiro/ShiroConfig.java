package com.try_their.try_their_project.util.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        /**
         * Shiro内置过滤器，可以实现相关权限的拦截器
         * 常用的过滤器：
         *    anon：无需认证/登录，可以访问
         *    authc：必须认证才能访问
         *    user：如果使用rememberMe的功能可以直接访问
         *    perms：该资源必须得到资源权限才能访问
         *    role：该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/index","anon");
        filterMap.put("/user_reg","anon");
        filterMap.put("/sidebar","authc");
        filterMap.put("/logout","logout");
        filterMap.put("/book_list","authc");
        filterMap.put("/sideOne","authc");
        filterMap.put("/sideTwo","authc");
        filterMap.put("/sideThere","authc");
        filterMap.put("/sideDown","authc");
        filterMap.put("/sideUpload","authc");
        factoryBean.setFilterChainDefinitionMap(filterMap);

        factoryBean.setLoginUrl("/index");//设置默认登录页面
        factoryBean.setUnauthorizedUrl("");//设置默认授权界面

        return factoryBean;
    }
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(MyRealm myRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }
    @Bean
    public MyRealm getMyRealm(){
        return new MyRealm();
    }

    /**
     * 配置ShiroDialect ，用户thymeleaf和shiro配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
