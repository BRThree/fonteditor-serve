package com.brthree.service;

import com.brthree.domain.ResponseResult;
import com.brthree.domain.entity.SysUser;
import com.brthree.domain.vo.UserLoginVo;

/**
 * @author BRThree
 */
public interface LoginService {
    ResponseResult<UserLoginVo> login(SysUser sysUser);
}