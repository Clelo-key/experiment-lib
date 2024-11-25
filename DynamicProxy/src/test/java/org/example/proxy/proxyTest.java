package org.example.proxy;

import org.example.aop.PoliteUserProxy;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;

/**
 * @Author: Fly
 * @CreateTime: 2024-11-24
 * @Version: 1.0
 */
public class proxyTest {
    @Test
    public void test() {
        User user = new User("张三",18);
//        user.meeting();
        PoliteUserProxy politeUserProxy = new PoliteUserProxy(user);
        politeUserProxy.meeting();
    }
}
