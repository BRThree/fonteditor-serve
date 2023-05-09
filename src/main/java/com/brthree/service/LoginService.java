package com.brthree.service;

import com.brthree.domain.ResponseResult;
import com.brthree.domain.entity.SysUser;
import com.brthree.domain.vo.UserLoginVo;

/**
 * @author BRThree
 */
public interface LoginService {
    /**
     * 登录
     * @param sysUser 用户
     * @return 用户信息
     */
    ResponseResult<UserLoginVo> login(SysUser sysUser);
}