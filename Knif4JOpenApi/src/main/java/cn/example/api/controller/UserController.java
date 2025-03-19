package cn.example.api.controller;

import cn.example.api.dal.User;
import cn.example.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-17
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
@Tag(name = "user")
public class UserController {
    @Resource
    UserService userService;

    @Operation(summary = "获取用户",description = "根据用户名获取用户")
    @GetMapping("get")
    public User getUser(@RequestParam("name") String name) {
        return userService.getUserByUsername(name);
    }
}
