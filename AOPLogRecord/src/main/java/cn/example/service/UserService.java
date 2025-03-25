package cn.example.service;

import cn.example.dao.UserDo;
import org.springframework.stereotype.Service;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-25
 * @Version: 1.0
 */
public interface UserService {
    UserDo get(String username);
    UserDo delete();
}
