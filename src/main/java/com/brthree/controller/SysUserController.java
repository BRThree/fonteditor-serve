package com.brthree.controller;

import com.brthree.domain.ResponseResult;
import com.brthree.domain.entity.SysUser;
import com.brthree.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BRThree
 */
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/register")
    public ResponseResult register(@RequestBody SysUser sysUser){
        return sysUserService.register(sysUser);
    }
}
