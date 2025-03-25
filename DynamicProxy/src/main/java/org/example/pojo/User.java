package org.example.pojo;

import org.example.function.MeetingUser;

/**
 * @Author: Fly
 * @CreateTime: 2024-11-24
 * @Version: 1.0
 */
public  class  User implements MeetingUser {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public void meeting() {
        System.out.println(this.name + " is in a meeting");
//        System.out.println(this.getName() + " is in a meeting");
    }

}
