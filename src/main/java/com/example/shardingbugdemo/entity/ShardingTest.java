package com.example.shardingbugdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sharding_test")
public class ShardingTest extends Model<ShardingTest> {

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

    /** 标题 **/
    private String title;

    /** 标题 **/
    @TableField("a_title")
    private String aTitle;

    /** 内容 **/
    private String content;

    /** 证件号码 **/
    private String zzhm;

    /** 关系人证件号 **/
    @TableField("related_zzhm")
    private String relatedZzhm;

    /** 有效标识：1、有效；0、无效 **/
    @TableField("alive_flag")
    private Integer aliveFlag;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
