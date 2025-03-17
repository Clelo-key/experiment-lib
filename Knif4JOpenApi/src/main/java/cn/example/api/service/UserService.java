package cn.example.api.service;

import cn.example.api.dal.User;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-17
 * @Version: 1.0
 */
public interface UserService {
    User getUserByUsername(String username);
}
