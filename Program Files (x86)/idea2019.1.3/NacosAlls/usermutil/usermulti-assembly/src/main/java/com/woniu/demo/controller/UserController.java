package com.woniu.demo.controller;

import com.woniu.api.form.UserVo;
import com.woniu.api.model.Result;
import com.woniu.demo.clients.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class UserController{

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/sendNacos")
    public Result sendNacos(Integer id,Double money){
        //列举实例
        List<ServiceInstance> instances = discoveryClient.getInstances("hyh");
       //获得第  0 个实例
        ServiceInstance serviceInstance = instances.get(0);
        //获得该鼓舞的地址
        URI uri = serviceInstance.getUri();
        //设置请求参数
        String url=uri+"/getPay?id="+id+"&money="+money;
        //发送请求
        Result forObject = restTemplate.getForObject(url, Result.class);
        return Result.success();
    }

    @Resource
    private UserClient client;
    @PostMapping("/sendOrder")
    public Result sendOrder(Integer id){
        log.info("{}",id);
        Result send = client.send(id, 100);
        return  send;
    }
    @PostMapping("sendLogin")
    public  Result sendLogin(@RequestBody UserVo user){

        log.info("{}",user);
        Result login = client.login(user);
        return  login;
    }
    @PostMapping("sendRegister")
    public Result sendRegister(@RequestBody UserVo user){
        log.info("{}",user);
        Result register = client.register(user);
        return  register;
    }
    @GetMapping("updataById")
    public Result UpdataById(@RequestParam("id")  Integer id){
        System.out.println("修改个人信息");
        log.info("{}",id);
        Result result = client.UpdateById(id);
        return  result;
    }
    @GetMapping("sendPersonal/{name}")
    public Result Personal(@PathVariable("name")String name){
        log.info("{}",name);
        System.out.println(name);
        Result personal = client.Personal(name);
        return Result.success(personal);
    }
}
