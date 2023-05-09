package com.brthree.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brthree.domain.ResponseResult;
import com.brthree.domain.entity.Font;
import com.brthree.domain.vo.FontInfoVo;
import com.brthree.domain.vo.FontProjectVo;
import com.brthree.mapper.FontMapper;
import com.brthree.service.FontService;
import com.brthree.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (Font)表服务实现类
 *
 * @author BRThree
 * @since 2023-05-05 19:55:21
 */
@Service("fontService")
public class FontServiceImpl extends ServiceImpl<FontMapper, Font> implements FontService {
    @Override
    public ResponseResult getFontProjectsById(Integer userId) {
        LambdaQueryWrapper<Font> query = new LambdaQueryWrapper<>();
        query.eq(Font::getUserId, userId);

        List<Font> fontList = list(query);

        List<FontInfoVo> fontInfoVos = fontList
                .stream()
                .map(font -> BeanCopyUtils.copyBean(font, FontInfoVo.class))
                .collect(Collectors.toList());

        FontProjectVo fontProjectVo = new FontProjectVo(userId, fontInfoVos);
        return ResponseResult.okResult(fontProjectVo);
    }

    @Override
    public ResponseResult updateFontProjects(FontProjectVo fontProjectVo) {
        // 删除所有该用户的字体
        LambdaQueryWrapper<Font> query = new LambdaQueryWrapper<>();
        query.eq(Font::getUserId, fontProjectVo.getUserId());
        remove(query);

        List<Font> fontList = fontProjectVo
                .getFontInfos()
                .stream()
                .map(fontInfoVo -> new Font(fontInfoVo.getId(),
                        fontInfoVo.getName(),
                        fontInfoVo.getFontJson(),
                        fontProjectVo.getUserId()))
                .collect(Collectors.toList());

        // 加入更新后的字体
        saveBatch(fontList);

        return ResponseResult.okResult();
    }
}
