package com.brthree.controller;
 
import com.brthree.domain.ResponseResult;
import com.brthree.service.OnlineService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (Online)表服务实现类
 *
 * @author BRThree
 * @since 2023-04-06 10:01:33
 */
@RestController
@RequestMapping(value = "/online", method = {RequestMethod.POST, RequestMethod.GET})
public class OnlineController {
    @Autowired
    private OnlineService onlineService;

    /**
     * 通过文件地址获取文件
     *
     * @param url 文件地址
     * @return 文件
     */
    @GetMapping(value = "/getOnlineByUrl", params = {"url"})
    public ResponseResult<String> getOnlineByUrl(@RequestParam String url) {
        return onlineService.getOnlineByUrl(url);
    }
}
