package org.example.dynamic.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Fly
 * @CreateTime: 2024-11-24
 * @Version: 1.0
 * @Description: 动态代理类，动态地为所有对象提供额外的职能。
 */
public class ActingDynamicProxy implements InvocationHandler {
    private Object target; // 代理对象
    private Object proxy; // 额外职能

    public Object bind(Object target, Object proxy) {
        this.target = target;
        this.proxy = proxy;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> proxyClass = this.proxy.getClass();

        Field name = this.target.getClass().getDeclaredField("name");
        name.setAccessible(true);
        String targetName = (String) name.get(this.target);

        Method start = proxyClass.getDeclaredMethod("start", String.class);
        Method end = proxyClass.getDeclaredMethod("end", String.class);

        start.invoke(this.proxy, targetName);
        method.invoke(this.target, args);
        end.invoke(this.proxy, targetName);

        return null;
    }
}
