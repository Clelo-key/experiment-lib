package org.example.pojo;

import org.example.function.KeepPoliteness;

import java.lang.reflect.Method;

/**
 * @Author: Fly
 * @CreateTime: 2024-11-25
 * @Version: 1.0
 */
public class Polite implements KeepPoliteness {

    @Override
    public void start(String  name) {
        System.out.println(name + "向所有人问好");
    }

    @Override
    public void end(String name) {
        System.out.println(name+ "向所有人说再见");
    }

}
