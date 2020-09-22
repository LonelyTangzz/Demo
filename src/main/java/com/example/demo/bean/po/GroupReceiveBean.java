package com.example.demo.bean.po;

import lombok.Data;

import java.util.List;

/**
 * @author Joker
 * @since 2020/8/27 15:24
 */
@Data
public class GroupReceiveBean {

    private Long usergroupid;

    private String usergroupname;

    private Long modifier;

    private String remark;

    private Long creator;

    private List<Long> userGroupIdList;
}
