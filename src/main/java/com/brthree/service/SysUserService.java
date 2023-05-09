package com.brthree.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.brthree.domain.ResponseResult;
import com.brthree.domain.entity.SysUser;


/**
 * 用户表(SysUser)表服务接口
 *
 * @author BRThree
 * @since 2023-05-04 18:33:42
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 注冊用戶
     * @param sysUser 用戶信息
     * @return boolean 是否成功
     */
    ResponseResult register(SysUser sysUser);
}
