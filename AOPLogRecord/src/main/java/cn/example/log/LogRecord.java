package cn.example.log;

import cn.example.dao.UserDo;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-25
 * @Version: 1.0
 */
@Component
@Aspect
public class LogRecord {
    @Pointcut("execution(public * cn.example.controller.UserController.get())")
    private void pt() {
    }


    @Before("pt()")
    public void method(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println(String.format("请求URL: { %s }", request.getRequestURL().toString()));
        System.out.println(String.format("模拟日志记录: { %s }", joinPoint.getArgs()[0] + "执行了get方法"));
    }

    @Around(value = "@annotation(aoplog)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, Aoplog aoplog) throws Throwable {
        System.out.println("方法执行前:" + aoplog.title());
        Object result = proceedingJoinPoint.proceed();
        System.out.println("方法执行后：" + aoplog.operation());
        return result;
    }


}
