package cn.example.controller;

import cn.example.dao.UserDo;
import cn.example.log.Aoplog;
import cn.example.service.UserService;
import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-25
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("get")
    public UserDo get(@PathParam("username") String username) {
        return userService.get(username);
    }

    @Aoplog(title = "删除用户信息",operation = "delete")
    @GetMapping("delete")
//    @DeleteMapping("delete") // 为了方便测试直接使用GetMapping
    public UserDo delete() {
        return userService.delete();
    }

}
