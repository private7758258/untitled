package com.woniu.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;


@Configuration
public class ShiroConfig {
    //注册realm
    @Bean
    public Realm realm() {
        CustomerRealm customerRealm = new CustomerRealm();
//        //设置hashed凭证匹配器
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        //使用MD加密
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        //设置散列次数
//        hashedCredentialsMatcher.setHashIterations(1024);
//        customerRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return customerRealm;
    }

    //注册安全管理器
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm());
        return defaultWebSecurityManager;
    }

    //注册shiro过滤器   shiro基于过滤器做的实现
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager());
        LinkedHashMap<String, String> shiroMap = new LinkedHashMap<>();
//        //设置白名单
        shiroMap.put("/user/login","anon");
        shiroMap.put("/**","user");
//        //把名单添加进过滤器
        factoryBean.setFilterChainDefinitionMap(shiroMap);
//        //设置拦截后跳转的网页
//        factoryBean.setUnauthorizedUrl("/login.html");
        return factoryBean;
    }

    //配置rememberMe
    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        //创建Cookie
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //设置cookie的生命周期
        simpleCookie.setMaxAge(60 * 60 * 24);
        //加入cookie
        cookieRememberMeManager.setCookie(simpleCookie);
        cookieRememberMeManager.setCipherKey(Base64.decode("ewweeleldoforidurdjrei=="));
        return cookieRememberMeManager;
    }
}
