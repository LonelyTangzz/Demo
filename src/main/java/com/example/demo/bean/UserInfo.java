package com.example.demo.bean;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Joker
 * @date 2020/8/14 12:03
 */
@Data
@Repository
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

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