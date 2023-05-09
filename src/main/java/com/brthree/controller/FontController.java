package com.brthree.controller;

import com.brthree.domain.ResponseResult;
import com.brthree.domain.vo.FontProjectVo;
import com.brthree.service.FontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author BRThree
 */
@RestController
public class FontController {
    @Autowired
    FontService fontService;

    @GetMapping("/getFontProjectsById")
    public ResponseResult getFontProjectsById(@RequestParam Integer userId) {
        return fontService.getFontProjectsById(userId);
    };

    @PostMapping("/updateFontProjects")
    public ResponseResult updateFontProjects(@RequestBody FontProjectVo fontProjectVo) {
        return fontService.updateFontProjects(fontProjectVo);
    };
}
