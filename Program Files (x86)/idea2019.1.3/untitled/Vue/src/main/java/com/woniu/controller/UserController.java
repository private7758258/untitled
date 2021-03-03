package com.woniu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniu.mapper.UserMapper;
import com.woniu.model.Result;
import com.woniu.model.User;
import com.woniu.service.UserService;
import com.woniu.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    public UserMapper userMapper;
    @Resource
    public UserService userService;
    //注册前的验证
    @RequestMapping("verifyName")

    public Result<User> verifyName(@RequestBody User user) {
        //设置查询的条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", user.getUsername());

        User u = userMapper.selectOne(wrapper);
        //如果查询为空说明此用户名没有被注册
        if (ObjectUtils.isEmpty(u)) {
            return new Result<User>(true, 200, "success", u);
        }
        return new Result<User>(false, 400, "fail", u);
    }

    @RequestMapping("register")
    //注册用户
    public Result<User> register(@RequestBody User user) {
        System.out.println(user + "传进来的数");
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), "qwert", 1024);
        String s = md5Hash.toHex();
        user.setPassword(s);
        user.setCold("qwert");
        int row = userMapper.insert(user);
        if (row == 1) {
            return new Result<User>(true, 200, "注册成功", user);
        }
        return new Result<User>(false, 400, "注册失败", user);
    }

    @RequestMapping("login")
    //用户登录
    public Result login(@RequestBody User user) {
        System.err.println(user + "--------------");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        User one = userService.getOne(queryWrapper);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), user.getCold(), 2048);
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建token令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(token);//用户登录
        //创建jwt并且返回
        HashMap<String, String> map = new HashMap<>();
        map.put("username",user.getUsername());
        String jwtToken = JWTUtil.createToken(map);


        return new Result(true, 200, "success", user);
    }
}

