package cn.example.log;

import java.lang.annotation.*;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-25
 * @Version: 1.0
 *  自定义操作日志记录注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Aoplog {
    /**
     * 模块名称
     */
    String title() default "";
    /**
     * 操作类型
     */
    String operation() default "";


}
