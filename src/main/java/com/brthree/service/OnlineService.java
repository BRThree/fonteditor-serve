package com.brthree.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.brthree.domain.ResponseResult;
import com.brthree.domain.entity.Online;


/**
 * (Online)表服务接口
 *
 * @author BRThree
 * @since 2023-04-06 10:01:33
 */
public interface OnlineService extends IService<Online> {

    /**
     * 通过文件地址获取文件
     *
     * @param url 文件地址
     * @return ResponseResult
     */
    ResponseResult<String> getOnlineByUrl(String url);
}
