package com.example.demo.dao;

import com.example.demo.bean.UserGroup;
import com.example.demo.bean.po.ReceiveBean;
import com.example.demo.bean.vo.UserGroupListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Joker
 * @since 2020/8/27 17:10
 */
@Mapper
@Repository
public interface UserGroupMapper  {

    /**
     * 插入一个新的用户组.
     *
     * @param record 用户组信息
     * @return 成功后返回该组用UUID_SHORT()生成的id，失败返回null
     */
    Long insertSelective(UserGroup record);

    /**
     * 根据主键查询用户组 {@param usergroupid}.
     *
     * @param usergroupid 用户组主键
     * @return 如果存在则返回该用户组，否则返回空
     */
    UserGroup selectByPrimaryKey(Long usergroupid);

    /**
     * 根据传入的id查找到用户组信息并更新 {@param record.usergroupid}.
     *
     * @param record 用于更新的用户组信息
     * @return 返回1表示更新成功，其他则代表失败
     */
    int updateByPrimaryKeySelective(UserGroup record);

    /**
     * 删除操作（为了保留数据，仅将用户组中的flag置为1）
     *
     * @param record 需要删除用户的id
     * @return 返回1代表操作成功，其余则代表失败
     */
    int deleteByGroupId(UserGroup record);

    /**
     * 列出该组中包含的组信息和成员信息.
     *
     * @param receiveBean 包含的页码，搜索类型，搜索关键字和组名
     * @return 返回该列表，其中包含用户组，以及用户组成员
     */
    List<UserGroupListVo> listGroupAndMember(ReceiveBean receiveBean);

    /**
     * 通过搜索的组名查看该组是否存在.
     *
     * @param record 包含的搜寻讯息
     * @return 返回null表示不存在，否则返回该组信息
     */
    UserGroup selectByGroupName(UserGroup record);

    /**
     * 使用Join的列出该组信息及成员信息
     *
     * @param receiveBean 包含的页码，搜索类型，搜索关键字和组名
     * @return 返回该列表，其中包含用户组，以及用户组成员
     */
    UserGroupListVo listGroupAndMemberByJoin(ReceiveBean receiveBean);
}