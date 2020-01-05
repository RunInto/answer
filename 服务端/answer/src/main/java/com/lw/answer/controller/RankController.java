package com.lw.answer.controller;

import com.lw.answer.entity.ExamRank;
import com.lw.answer.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/rank")
public class RankController {
    @PostMapping("/list")
    public Result searchRankList() {
        return new Result(0,"success", new ExamRank().selectAll());
    }
}
