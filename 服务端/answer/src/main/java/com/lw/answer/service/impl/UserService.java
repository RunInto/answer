package com.lw.answer.service.impl;

import com.lw.answer.entity.User;
import com.lw.answer.mapper.UserMapper;
import com.lw.answer.service.IUserService;
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
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

}
