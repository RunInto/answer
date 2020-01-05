package com.lw.answer.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lw.answer.entity.User;
import com.lw.answer.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lw
 * @since 2020-01-01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public Result login(@RequestBody User u) {
        return new Result(0,"success",u.selectOne(new QueryWrapper<>(u)));
    }

}

