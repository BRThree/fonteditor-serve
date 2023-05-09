package com.brthree.controller;

import com.brthree.domain.ResponseResult;
import com.brthree.domain.entity.SysUser;
import com.brthree.domain.vo.UserLoginVo;
import com.brthree.service.EmailService;
import com.brthree.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author BRThree
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/login")
    public ResponseResult<UserLoginVo> login(@RequestBody SysUser sysUser){
        return loginService.login(sysUser);
    }

    @GetMapping("/sendVerificationCode")
    public ResponseResult<Boolean> sendVerificationCode(@RequestParam String email) {
        return emailService.sendEmailVerificationCode(email);
    }
}