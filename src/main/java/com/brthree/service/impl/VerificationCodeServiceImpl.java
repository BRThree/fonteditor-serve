package com.brthree.service.impl;

import com.brthree.service.VerificationCodeService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author BRThree
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    private final String[] metaCode={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    @Override
    public String generateVerificationCode() {
        Random random = new Random();
        StringBuilder verificationCode = new StringBuilder();
        int generateVerificationCodeLength = 6;
        while (verificationCode.length()< generateVerificationCodeLength){
            int i = random.nextInt(metaCode.length);
            verificationCode.append(metaCode[i]);
        }
        return verificationCode.toString();
    }
}