package org.example.dynamic.proxy;

import org.example.function.MeetingUser;
import org.example.pojo.Meal;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;


/**
 * @Author: Fly
 * @CreateTime: 2024-11-25
 * @Version: 1.0
 */
public class DynamicProxyTest {
    @Test
    void  test(){
        ActingDynamicProxy politeDynamicProxy = new ActingDynamicProxy();
        MeetingUser bind = (MeetingUser) politeDynamicProxy.bind(new User("张三", 19), new Meal());
        bind.meeting();

    }
}
