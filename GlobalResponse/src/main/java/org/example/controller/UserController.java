package org.example.controller;

import org.example.config.CommonResult;
import org.example.config.ErrorCode;
import org.example.config.MyError;
import org.example.dao.User;
import org.springframework.web.bind.annotation.*;

import static org.example.config.CommonResult.success;

/**
 * @Author: Fly
 * @CreateTime: 2024-11-18
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public CommonResult<User> getUser(@RequestParam("id") int id) {
        User WangFei = new User(1000, "王菲", 18);
        // 空指针异常
        if (id < 1000) {
            throw new NullPointerException();
        }
        return success(WangFei);
    }

    @DeleteMapping("")
    public CommonResult<User> delete(@RequestParam("id") int id) {
        if(id < 1000) {
            ErrorCode errorCode = new ErrorCode(750, "你不具备该权限");
            throw new MyError(errorCode);
        }
        return success(null);
    }

}
