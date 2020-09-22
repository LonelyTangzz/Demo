package com.example.demo.bean;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Joker
 * @since 2020/8/27 15:50
 */
@Data
@Repository
public class UserGroupMember implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long groupmemberid;

    private Long usergroupid;

    private Integer objecttype;

    private Long objectid;

    private Byte flag;

    private Long creator;

    private Date createtime;

    private Long modifier;

    private Date modifytime;

}