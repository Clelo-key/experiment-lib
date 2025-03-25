package org.example.dynamic.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.example.pojo.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-20
 * @Version: 1.0
 *
 */
public class CGlibDynamicProxy implements MethodInterceptor {
    private Object target; // 被代理对象
    private Object proxy; // 额外职能

    public CGlibDynamicProxy(Object target, Object proxy) {
        this.target = target;
        this.proxy = proxy;
    }

    public Object bind() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        Object o = enhancer.create();
        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Method start = proxy.getClass().getDeclaredMethod("start", String.class);
        Method end = proxy.getClass().getDeclaredMethod("end", String.class);

        Field name = target.getClass().getDeclaredField("name");
        name.setAccessible(true);
        String targetName = (String) name.get(target);

        start.invoke(proxy,targetName);
        System.out.println("【增强方法】代理对象正在执行的方法：" + method.getName());
        /**
         * 注意以下两条语句的不同：
         * invoke使用target执行目标方法（也就是案例中的meeting）
         * invokeSuper是使用o（cglib生成的代理类的对象）来执行增强后的目标方法（CGLIB$meeting$）
         * */
        Object result = methodProxy.invoke(target, objects);
//        Object result = methodProxy.invokeSuper(o, objects);
        end.invoke(proxy, targetName);

        return result;
    }
}
