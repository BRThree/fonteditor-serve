package com.brthree.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author BRThree
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterVo {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 验证码
     */
    private String verificationCode;
}
