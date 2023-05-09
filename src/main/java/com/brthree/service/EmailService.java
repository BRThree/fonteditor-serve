package com.brthree.service;

import com.brthree.domain.ResponseResult;

/**
 * @author BRThree
 */
public interface EmailService {
    /**
     * 发送验证码
     *
     * @param toAddress 发送的地址
     * @return boolean 是否发送成功
     */
    ResponseResult<Boolean> sendEmailVerificationCode(String toAddress);
}
