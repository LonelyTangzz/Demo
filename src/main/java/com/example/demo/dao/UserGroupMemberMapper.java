package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.UserGroup;
import com.example.demo.bean.UserGroupMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Joker
 * @since 2020/8/27 17:15
 */
@Mapper
@Repository
public interface UserGroupMemberMapper extends BaseMapper<UserGroupMember> {
    /**
     * 根据组成员id删除成员信息
     *
     * @param groupmemberid 组内成员id
     * @return 操作成功返回1，失败返回0
     */
    int deleteByPrimaryKey(Long groupmemberid);

    /**
     * 将组内成员信息插入到表中
     *
     * @param record 组员信息
     * @return 返回1代表成功，0代表失败
     */
    int insertSelective(UserGroupMember record);

    /**
     * 从表中查询是否有成员id等于的成员信息的 {@param groupmemberid}.
     *
     * @param groupmemberid 被查询的组成员id
     * @return 如果没有则返回null，否则返回查询出来的用户组成员
     */
    UserGroupMember selectByPrimaryKey(Long groupmemberid);

    /**
     * 更新通过用户id选择的用户组成员的消息.
     *
     * @param record 准备更新的成员
     * @return 返回1表示成功，否则失败
     */
    int updateByPrimaryKeySelective(UserGroupMember record);

    /**
     * 插入一个用户组内的一系列的组员
     *
     * @param objectid  用户id列表
     * @param userGroup 包含用户组的信息
     * @return 返回1表示成功，否则失败
     */
    int insertListMember(List<Long> objectid, @Param("usergroup") UserGroup userGroup);

    /**
     * 删除组中包含的成员（并非删除数据，而是将flag设置为1）
     *
     * @param userGroup 包含用户组的信息
     * @return 返回1表示成功，否则失败
     */
    int deleteByUserGroupId(UserGroup userGroup);

    /**
     * 列出该组中包含的成员.
     *
     * @param userGroupId 该组的id
     * @return 返回组成员列表，如果没有则返回null
     */
    List<UserGroupMember> selectByGroupId(Long userGroupId);
}