package com.brthree.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brthree.domain.entity.Font;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Font)表数据库访问层
 *
 * @author BRThree
 * @since 2023-05-05 19:55:21
 */
@Mapper
public interface FontMapper extends BaseMapper<Font> {

}
