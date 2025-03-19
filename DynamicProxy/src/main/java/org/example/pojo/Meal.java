package org.example.pojo;

import org.example.function.MentalStatue;


/**
 * @Author: Fly
 * @CreateTime: 2024-11-25
 * @Version: 1.0
 */
public class Meal implements MentalStatue {
    @Override
    public void start(String name) {
        System.out.println(name+"吃早餐");
    }

    @Override
    public void end(String name) {
        System.out.println(name+"吃晚餐");
    }
}
