package com.brthree.service;

/**
 * @author BRThree
 */
public interface VerificationCodeService {
    /**
     * 生成验证码
     *
     * @return String
     */
    String generateVerificationCode();
}
