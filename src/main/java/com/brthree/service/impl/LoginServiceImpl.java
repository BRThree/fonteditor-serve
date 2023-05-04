package com.brthree.service.impl;

import com.brthree.domain.ResponseResult;
import com.brthree.domain.entity.LoginUser;
import com.brthree.domain.entity.SysUser;
import com.brthree.domain.vo.UserInfoVo;
import com.brthree.domain.vo.UserLoginVo;
import com.brthree.service.LoginService;
import com.brthree.utils.BeanCopyUtils;
import com.brthree.utils.JwtUtil;
import com.brthree.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author BRThree
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult<UserLoginVo> login(SysUser sysUser) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(sysUser.getUserName(),sysUser.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断是否认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid 生成token
        // 获取当前对象
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getSysUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //把用户信息存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);

        //把token和userinfo封装 返回
        //把User转换成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getSysUser(), UserInfoVo.class);
        UserLoginVo vo = new UserLoginVo(jwt,userInfoVo);
        return ResponseResult.okResult(vo);
    }
}