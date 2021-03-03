package com.woniu;

import com.woniu.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {
    @Resource
//    private UserMapper userMapper;
//    @Resource
    private
    @Test
    void contextLoads() {
        User user = new User();
        user.setPassword("123");
        user.setUsername("123");
    }

}
