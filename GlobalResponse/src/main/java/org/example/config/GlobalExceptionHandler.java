package org.example.config;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import static org.example.config.GlobalErrorCodeConstants.*;

/**
 * @Author: Fly
 * @CreateTime: 2024-11-18
 * @Version: 1.0
 * @Description: 全局异常处理
 */
@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {
    /**
     * 处理 SpringMVC 请求地址不存在
     *
     * 注意，它需要设置如下两个配置项：
     * 1. spring.mvc.throw-exception-if-no-handler-found 为 true
     * 2. spring.mvc.static-path-pattern 为 /statics/**
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult<?> noHandlerFoundExceptionHandler(NoHandlerFoundException ex) {
        return CommonResult.error(NOT_FOUND.getCode(), String.format("请求地址不存在:%s", ex.getRequestURL()));
    }
    /**
     * 空指针
     * */
    @ExceptionHandler(NullPointerException.class)
    public CommonResult<?> nullPointerExceptionHandler(NullPointerException ex) {
        return CommonResult.error(NULL_POINT_ERROR.getCode(),"空指针异常");
    }
    /**
     * 自定义错误
     * */
    @ExceptionHandler(MyError.class)
    public CommonResult<?> myErrorHandler(MyError ex) {
        return CommonResult.error(ex.getCode(), ex.getMessage());
    }
    /**
     * Thrown to indicate that a method has been passed an illegal or inappropriate argument.
     * */
    @ExceptionHandler(IllegalArgumentException.class)
    public CommonResult<?> illegalArgumentExceptionHandler(IllegalArgumentException ex) {
        return CommonResult.error(INTERNAL_SERVER_ERROR.getCode(), ex.getMessage());
    }



}
