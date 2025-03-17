package cn.example.api.service;

import cn.example.api.dal.User;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Service;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-17
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    public User getUserByUsername(String username) {
        return new User(username,1L,"123456");
    }
}
