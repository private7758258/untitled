package com.woniu.demo.clients;

import com.woniu.api.form.UserVo;
import com.woniu.api.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//标识是一个feign的客户端，其中value表示被调用服务端的名字
@FeignClient(value = "hyh",contextId = "user")
public interface UserClient {
    @GetMapping("/getPay")
    public Result send(@RequestParam("id") Integer id,
                       @RequestParam("money") double money);

    @PostMapping("login")
    public Result login(@RequestBody UserVo user);
    @PostMapping("register")
    public Result register(@RequestBody UserVo user);
    @GetMapping("updateById")
    public Result UpdateById(@RequestParam("id") Integer id);
    @RequestMapping("personal/{name}")
    public Result Personal(@PathVariable("name") String name);
}
