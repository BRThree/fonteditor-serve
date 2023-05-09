package com.brthree.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.brthree.domain.ResponseResult;
import com.brthree.domain.entity.Font;
import com.brthree.domain.vo.FontProjectVo;


/**
 * (Font)表服务接口
 *
 * @author BRThree
 * @since 2023-05-05 19:55:21
 */
public interface FontService extends IService<Font> {
    /**
     * {@inheritDoc}
     * @param userId
     * @return
     */
    ResponseResult getFontProjectsById(Integer userId);

    /**
     * {@inheritDoc}
     * @param fontProjectVo
     * @return
     */
    ResponseResult updateFontProjects(FontProjectVo fontProjectVo);
}
