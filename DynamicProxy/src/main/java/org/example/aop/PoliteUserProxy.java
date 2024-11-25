package org.example.aop;

import org.example.function.MeetingUser;
import org.example.pojo.User;

/**
 * @Author: Fly
 * @CreateTime: 2024-11-24
 * @Version: 1.0
 */
public class PoliteUserProxy implements MeetingUser {
    private User user;

    public PoliteUserProxy(User user) {
        super();
        this.user = user;
    }

    public void politenessStart() {
        System.out.println(this.user.getName()+"向所有人握手说你好");
    }

    public void politenessEnd() {
        System.out.println(this.user.getName()+"向所有人挥手说再见");
    }

    @Override
    public void meeting() {
        politenessStart();
        user.meeting();
        politenessEnd();
    }


}
