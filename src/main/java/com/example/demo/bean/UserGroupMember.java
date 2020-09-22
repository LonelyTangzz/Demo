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
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Joker
 * @since 2020/8/27 15:50
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Repository
@TableName("usergroupmember")
@ApiModel(value = "UserGroupMember对象", description = "用户组成员对象")
public class UserGroupMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(value = "用户成员ID", example = "自动生成uuid()")
    @TableId("groupmemberid")
    private Long groupmemberid;

    @ApiModelProperty(value = "用户组ID", example = "根据所在用户组写入")
    @TableField("usergroupid")
    private Long usergroupid;

    private Integer objecttype;

    private Long objectid;

    private Byte flag;

    private Long creator;

    private Date createtime;

    private Long modifier;

    private Date modifytime;

}