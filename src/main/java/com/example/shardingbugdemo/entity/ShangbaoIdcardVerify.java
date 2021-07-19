package com.example.shardingbugdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 普保通二要素表
 * @author kean.hua
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("shangbao_idcard_verify")
public class ShangbaoIdcardVerify extends Model<ShangbaoIdcardVerify> {

    private static final long serialVersionUID = 1L;

    /** 编号 **/
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 创建时间 **/
    @TableField("create_time")
    private Date createTime;

    /** 更新时间 **/
    @TableField("update_time")
    private Date updateTime;

    /** 姓名 **/
    private String name;

    /** 身份证，加密 **/
    private String idcard;

    /** 结果 **/
    private Integer result;

    /** 操作时间 **/
    @TableField("operate_time")
    private Date operateTime;

    /** 操作人ID **/
    @TableField("operator_id")
    private Long operatorId;

    /** 操作人名称 **/
    @TableField("operator_name")
    private String operatorName;

    /** 有效标识：1、有效；0、无效 **/
    private Integer valid;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
