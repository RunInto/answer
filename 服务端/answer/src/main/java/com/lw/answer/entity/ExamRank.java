package com.lw.answer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("example_rank")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamRank extends Model<ExamRank> {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String code;
    private String name;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
