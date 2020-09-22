package com.example.demo.service;

import com.example.demo.bean.UserGroup;
import com.example.demo.bean.vo.ResultBody;

import java.util.List;

/**
 * @author Joker
 * @since 2020/8/27 19:39
 */
public interface UserGroupMemberService {
    /**
     * 添加有关一个组的成员列表
     *
     * @param userGroupMemberList 成员对象id
     * @return 操作结果
     */
    ResultBody save(List<Long> userGroupMemberList, UserGroup userGroup);

    /**
     * 从用户组ID等于的{@param userGroupId}成员表中删除数据.
     *
     * @param userGroup 将被删除的用户组
     * @return 操作结果
     */
    ResultBody deleteByUserGroupId(UserGroup userGroup);

    /**
     * 获取所有组ID等于searchKey{@param userGroupId}的成员信息
     *
     * @param userGroupId 搜索的用户组id
     * @return 操作结果
     */
    ResultBody getMemberByGroupId(Long userGroupId);

}
