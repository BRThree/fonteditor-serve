package com.brthree.domain.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author BRThree
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FontInfoVo {
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
}
