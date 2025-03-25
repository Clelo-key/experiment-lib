package org.example.dynamic.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import org.example.pojo.Polite;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-20
 * @Version: 1.0
 * 运行此测试方法需要加上参数 -add-opens java.base/java.lang=ALL-UNNAMED
 */
public class CGLIBDynamicProxyTest {
    @Test
    public void test() {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\"); // 生成字节码文件
        User proxy = (User)new CGlibDynamicProxy(new User("张三", 12), new Polite()).bind();
        proxy.meeting();
    }
}
