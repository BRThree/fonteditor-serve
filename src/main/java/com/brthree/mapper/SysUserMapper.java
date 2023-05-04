package com.brthree.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brthree.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(User)表数据库访问层
 *
 * @author BRThree
 * @since 2022-02-03 16:25:39
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}

