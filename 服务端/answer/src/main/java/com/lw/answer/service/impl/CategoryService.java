package com.lw.answer.service.impl;

import com.lw.answer.entity.Category;
import com.lw.answer.mapper.CategoryMapper;
import com.lw.answer.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 类别表 服务实现类
 * </p>
 *
 * @author lw
 * @since 2020-01-01
 */
@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
