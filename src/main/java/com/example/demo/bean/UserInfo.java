package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Joker
 * @date 2020/8/14 12:03
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("userinfo")
@ApiModel(value = "User对象", description = "用户对象")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(value = "用户ID", example = "自动生成uuid()")
    @TableId("userid")
    private Long userid;

    private String username;

    private String password;

    private String fullname;

    private Byte sex;

    private String degree;

    private String titled;

    private String birth;

    private String email;

    private String phone;

    private String remark;

    private Long creater;

    private Date createtime;

    private Long modifier;

    private Date modifytime;

    private Byte flag;

}