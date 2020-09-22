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
@TableName("usergroup")
@ApiModel(value = "UserGroup对象", description = "用户组对象")
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

    @NotNull
    @ApiModelProperty(value = "删除标志", example = "0")
    @TableField("flag")
    private Byte flag;

    @NotNull
    @ApiModelProperty(value = "创建者", example = "1")
    @TableField("creator")
    private Long creator;

    @NotNull
    @ApiModelProperty(value = "创建时间", example = "2020-9-20 13:14")
    @TableField("createtime")
    private Date createtime;

    @ApiModelProperty(value = "修改者", example = "1")
    @TableField("modifier")
    private Long modifier;

    @ApiModelProperty(value = "修改时间", example = "2020-9-20 13:14")
    @TableField("modifytime")
    private Date modifytime;
}