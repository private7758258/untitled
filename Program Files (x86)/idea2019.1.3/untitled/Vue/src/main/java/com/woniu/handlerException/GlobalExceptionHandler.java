package com.woniu.handlerException;

import com.woniu.model.Result;
import com.woniu.model.StatusCode;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//以json形式返回
public class GlobalExceptionHandler {
    @ExceptionHandler(IncorrectCredentialsException.class)
    public Result handleIncorrectCredentialsException() {
        return new Result(false, StatusCode.INCORRECTCREDENTIALS, "密码错误");
    }

    @ExceptionHandler(UnknownAccountException.class)
    public Result handleUnknownAccountException() {
        return new Result(false, StatusCode.NUKNOWACCOUNT, "当前用户尚未注册");
    }

    //异常总类来进行兜底
    @ExceptionHandler(Exception.class)
    public Result handleException() {
        return new Result(false, StatusCode.ERROR, "未知异常");
    }


}
