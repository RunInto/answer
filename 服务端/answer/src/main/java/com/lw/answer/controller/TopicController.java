package com.lw.answer.controller;

import com.alibaba.fastjson.JSON;
import com.lw.answer.entity.MultipleChoice;
import com.lw.answer.entity.SingleChoice;
import com.lw.answer.entity.Topic;
import com.lw.answer.entity.TrueFalseQuestion;
import com.lw.answer.mapper.MultipleChoiceMapper;
import com.lw.answer.mapper.SingleChoiceMapper;
import com.lw.answer.mapper.TrueFalseQuestionMapper;
import com.lw.answer.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private SingleChoiceMapper singleChoiceMapper;

    @Autowired
    private MultipleChoiceMapper multipleChoiceMapper;

    @Autowired
    private TrueFalseQuestionMapper trueFalseQuestionMapper;
    @PostMapping("/addTopic")
    public Result addTopic(HttpServletRequest r) {

        String title = r.getParameter("title");
        String selectCategory = r.getParameter("selectCategory");
        String options = r.getParameter("options");
        String result = r.getParameter("result");
        Topic topic = JSON.parseObject(options, Topic.class);

        if (Integer.parseInt(selectCategory) == 2) {
            SingleChoice singleChoice = new SingleChoice();
            singleChoice.setCategoryId(Integer.parseInt(selectCategory));
            String option ="A." + topic.getA() + "|" + "B." + topic.getB() + "|" + "C." + topic.getC() + "|" + "D." + topic.getD();
            singleChoice.setOptions(option);
            singleChoice.setTitle(title);
            singleChoice.setResult(result);
            singleChoiceMapper.insert(singleChoice);
        }else if (Integer.parseInt(selectCategory) == 3) {
            MultipleChoice multipleChoice = new MultipleChoice();
            multipleChoice.setTitle(title);
            multipleChoice.setCategoryId(Integer.parseInt(selectCategory));
            String option ="A." + topic.getA() + "|" + "B." + topic.getB() + "|" + "C." + topic.getC() + "|" + "D." + topic.getD() + "|" + "E." + topic.getE() + "|" + "F." + topic.getF();
            multipleChoice.setOptions(option);
            String [] formatResult = result.split("\\.");
            String resultStr = "";
            for ( int i = 0; i<formatResult.length; i++) {
                resultStr +=  formatResult[i] += "|";
            }
            resultStr = resultStr.substring(0,resultStr.length() - 1);
            multipleChoice.setResult(resultStr);
            multipleChoiceMapper.insert(multipleChoice);
        }else {
            TrueFalseQuestion trueFalseQuestion = new TrueFalseQuestion();
            trueFalseQuestion.setCategoryId(Integer.parseInt(selectCategory));
            trueFalseQuestion.setTitle(title);
            trueFalseQuestion.setResult(result);
            trueFalseQuestionMapper.insert(trueFalseQuestion);
        }
        return new Result(0,"success",null);
    }
}
