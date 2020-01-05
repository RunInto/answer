package com.lw.answer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 多选题目表
 * </p>
 *
 * @author lw
 * @since 2020-01-01
 */
public class MultipleChoice extends OptionFormat {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String code;

    private String title;

    private Integer categoryId;

    private String options;

    @TableField(exist = false)
    public List<String> formatOption = new ArrayList<>();

    @TableField(exist = false)
    public List<String> formatResult = new ArrayList<>();
    @TableField(exist = false)
    public String answerResult = "";
    private String result;
    @TableField(exist = false)
    private List<String> selected = new ArrayList<>();

    @TableField(exist = false)
    public String isDone = "";
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
        this.format(this.options, this.formatOption);
    }

    public String getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(String answerResult) {
        this.answerResult = answerResult;
    }

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(List<String> selected) {
        this.selected = selected;
    }

    public List<String> getFormatOption() {
        return formatOption;
    }

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }

    public void setFormatOption(List<String> formatOption) {
        this.formatOption = formatOption;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        this.format(this.result, this.formatResult);
    }
}
