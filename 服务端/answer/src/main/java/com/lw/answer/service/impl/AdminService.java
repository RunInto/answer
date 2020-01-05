package com.lw.answer.service.impl;

import com.lw.answer.entity.Admin;
import com.lw.answer.mapper.AdminMapper;
import com.lw.answer.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lw
 * @since 2020-01-01
 */
@Service
public class AdminService extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
