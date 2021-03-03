package com.woniu.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniu.mapper.UserMapper;
import com.woniu.model.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

public class CustomerRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取User
        User user = (User) principalCollection.getPrimaryPrincipal();
        return null;
    }

    //    认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = (String) token.getPrincipal();
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("username", name);
        User user = userMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(user)) {
            return new SimpleAuthenticationInfo(
                    user,
                    user.getPassword(),
                    ByteSource.Util.bytes(user.getCold()),
                    this.getName());
        }
        return null;
    }
}
