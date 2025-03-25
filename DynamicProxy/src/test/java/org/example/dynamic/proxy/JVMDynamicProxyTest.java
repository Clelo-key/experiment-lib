package org.example.dynamic.proxy;

import org.example.function.MeetingUser;
import org.example.pojo.Meal;
import org.example.pojo.Polite;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;


/**
 * @Author: Fly
 * @CreateTime: 2024-11-25
 * @Version: 1.0
 */
public class JVMDynamicProxyTest {
    @Test
    void test() {
        JDKDynamicProxy politeDynamicProxy = new JDKDynamicProxy();
        MeetingUser proxyMeal = (MeetingUser) politeDynamicProxy.bind(new User("张三", 19), new Meal());
        proxyMeal.meeting();
        System.out.println("_________________");
        MeetingUser proxyPolite = (MeetingUser) politeDynamicProxy.bind(new User("张三", 19), new Polite());
        proxyPolite.meeting();
    }
}
