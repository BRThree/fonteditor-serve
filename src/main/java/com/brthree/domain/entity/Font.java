package com.brthree.domain.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Font)表实体类
 *
 * @author BRThree
 * @since 2023-05-05 19:55:21
 */
@SuppressWarnings("serial, RedundantSuppression")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("font")
public class Font  {
    /**
     * 主键@TableId
     */
    private String id;

    /**
     * 字体名称
     */
    private String name;

    /**
     * 字体数据
     */
    private JSONObject fontJson;

    /**
     * 用户id
     */
    private Integer userId;
}
