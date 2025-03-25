package cn.example.service;

import cn.example.dao.UserDo;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-25
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDo get(String username) {
        UserDo userDo = new UserDo();
        userDo.setName(username);
        userDo.setAge(new Random().nextInt(100));
        return userDo;
    }

    @Override
    public UserDo delete() {
        return new UserDo();
    }
}
