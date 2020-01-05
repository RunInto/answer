package com.lw.answer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lw.answer.entity.ExamPaper;
import com.lw.answer.entity.MultipleChoice;
import com.lw.answer.entity.SingleChoice;
import com.lw.answer.entity.TrueFalseQuestion;
import com.lw.answer.result.Result;
import com.lw.answer.service.IMultipleChoiceService;
import com.lw.answer.service.ISingleChoiceService;
import com.lw.answer.service.ITrueFalseQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/examPaper")
public class ExamPaperController {
    @Autowired
    private ISingleChoiceService singleChoiceService;
    @Autowired
    private IMultipleChoiceService multipleChoiceService;
    @Autowired
    private ITrueFalseQuestionService trueFalseQuestionService;

    @GetMapping("/searchOptions")
    public Result searchOptions() {
        //判断
        QueryWrapper<TrueFalseQuestion> trueFalseQueryWrapper = new QueryWrapper<>();
        trueFalseQueryWrapper.last("order by rand() limit 10");

        //单选
        QueryWrapper<SingleChoice> singleQueryWrapper = new QueryWrapper<>();
        singleQueryWrapper.last("order by rand() limit 35");

        //多选
        QueryWrapper<MultipleChoice> multipleQueryWrapper = new QueryWrapper<>();
        multipleQueryWrapper.last("order by rand() limit 8");

        List<SingleChoice> singleChoiceList = singleChoiceService.list(singleQueryWrapper);
        List<TrueFalseQuestion> trueFalseList = trueFalseQuestionService.list(trueFalseQueryWrapper);
        List<MultipleChoice> multipleChoices = multipleChoiceService.list(multipleQueryWrapper);

        ExamPaper examPaper = new ExamPaper(singleChoiceList,multipleChoices,trueFalseList);
        Result result = new Result(0,"success",examPaper);
        return result;
    }

}
