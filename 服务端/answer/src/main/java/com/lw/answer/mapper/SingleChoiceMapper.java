package com.lw.answer.mapper;

import com.lw.answer.entity.SingleChoice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 单选题目表 Mapper 接口
 * </p>
 *
 * @author lw
 * @since 2020-01-01
 */
@Mapper
public interface SingleChoiceMapper extends BaseMapper<SingleChoice> {

}
