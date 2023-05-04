package com.brthree.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brthree.domain.ResponseResult;
import com.brthree.domain.entity.Online;
import com.brthree.enums.AppHttpCodeEnum;
import com.brthree.mapper.OnlineMapper;
import com.brthree.service.OnlineService;
import com.brthree.utils.HttpUtil;
import org.springframework.stereotype.Service;

/**
 * (Online)表服务实现类
 *
 * @author BRThree
 * @since 2023-04-06 10:01:33
 */
@Service("onlineService")
public class OnlineServiceImpl extends ServiceImpl<OnlineMapper, Online> implements OnlineService {


    @Override
    public ResponseResult<String> getOnlineByUrl(String url) {
        String res = HttpUtil.sendGet(url, "UTF-8");

        if(StringUtils.isEmpty(res)) {
            return ResponseResult.errorResult(AppHttpCodeEnum.SOURCE_ERROR);
        }

        return ResponseResult.okResult(res);
    }
}
