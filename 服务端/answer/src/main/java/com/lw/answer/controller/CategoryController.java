package com.lw.answer.controller;


import com.lw.answer.entity.Category;
import com.lw.answer.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 类别表 前端控制器
 * </p>
 *
 * @author lw
 * @since 2020-01-01
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("/list")
    public Result searchCateGoryList() {
        Category category = new Category();
        List<Category> categories = category.selectAll();
        Result result = new Result(0,"success",categories);
        return result;
    }
}

