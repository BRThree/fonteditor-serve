package com.brthree.service.impl;

import com.brthree.domain.ResponseResult;
import com.brthree.enums.AppHttpCodeEnum;
import com.brthree.service.EmailService;
import com.brthree.service.VerificationCodeService;
import com.brthree.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;

/**
 * @author BRThree
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    /**
     * 邮件发件人
     */
    @Value("${mail.fromMail.fromAddress}")
    private String fromAddress;
    @Autowired
    TemplateEngine templateEngine;
    @Autowired
    private VerificationCodeService verificationCodeService;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult<Boolean> sendEmailVerificationCode(String toAddress) {
        //调用 VerificationCodeService 生产验证码
        String verifyCode = verificationCodeService.generateVerificationCode();
        //将验证码存入redis 时效5分钟
        String key = "emailVerificationCode:" + toAddress;
        redisCache.setCacheObject(key, verifyCode);
        redisCache.expire(key, 300);
        //创建邮件正文
        Context context = new Context();
        context.setVariable("verifyCode", Arrays.asList(verifyCode.split("")));
        //将模块引擎内容解析成html字符串
        String emailContent = templateEngine.process("EmailVerificationCode", context);
        MimeMessage message=mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(fromAddress);
            helper.setTo(toAddress);
            helper.setSubject("注册验证码");
            helper.setText(emailContent,true);
            mailSender.send(message);
            return ResponseResult.okResult(true);
        }catch (MessagingException e) {
            e.printStackTrace();
            return ResponseResult.errorResult(AppHttpCodeEnum.EMAIL_SEND_ERROR);
        }
    }
}