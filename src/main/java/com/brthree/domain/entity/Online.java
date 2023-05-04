package com.brthree.domain.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Online)表实体类
 *
 * @author BRThree
 * @since 2023-04-06 10:01:33
 */
@SuppressWarnings("serial, RedundantSuppression")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("online")
public class Online  {
    //主键@TableId
    private Long id;

    //在线字体名称
    private String name;
    //字体来源
    private String form;
    //逻辑删除
    private Integer delFlag;
}
