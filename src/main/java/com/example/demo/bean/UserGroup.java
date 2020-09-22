package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Joker
 * @since 2020/8/27 15:49
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("userinfo")
@ApiModel(value = "UserGroup对象", description = "用户对象")
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(value = "用户ID", example = "自动生成uuid()")
    @TableId("usergroupid")
    private Long usergroupid;


    @NotBlank
    @ApiModelProperty(value = "用户名", example = "张三")
    @TableField("usergroupname")
    private String usergroupname;

    @ApiModelProperty(value = "备注", example = "芜湖，起飞！")
    @TableField("remark")
    private String remark;

    private Byte flag;

    private Long creator;

    private Date createtime;

    private Long modifier;

    private Date modifytime;
}