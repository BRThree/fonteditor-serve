package com.brthree.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brthree.domain.entity.Online;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Online)表数据库访问层
 *
 * @author BRThree
 * @since 2023-04-06 10:01:33
 */
@Mapper
public interface OnlineMapper extends BaseMapper<Online> {
}
