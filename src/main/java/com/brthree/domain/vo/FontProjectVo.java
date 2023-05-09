package com.brthree.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author BRThree
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FontProjectVo {
    /**
     * 用戶Id
     */
    Integer userId;

    /**
     * 字体信息
     */
    List<FontInfoVo> fontInfos;
}
