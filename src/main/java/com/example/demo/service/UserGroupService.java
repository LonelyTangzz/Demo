package com.example.demo.service;

import com.example.demo.bean.UserGroup;
import com.example.demo.bean.vo.ResultBody;
import com.example.demo.bean.po.GroupReceiveBean;
import com.example.demo.bean.po.ReceiveBean;

/**
 * @author Joker
 * @since 2020/8/27 20:02
 */
public interface UserGroupService {
    /**
     * 该方法用于检查组是否存在.
     *
     * @param userGroup 用户组
     * @return 如果存在返回true ,否则返回false.
     */
    Boolean userGroupExists(UserGroup userGroup);

    /**
     * 该方法用于插入用户组信息.
     *
     * @param groupReceiveBean 该bean包含在该组中的成员以及需要插入的组中
     * @return 关于插入操作后的结果
     */
    ResultBody save(GroupReceiveBean groupReceiveBean);

    /**
     * 此方法用于更新用户组内信息
     *
     * @param groupReceiveBean 将要改变的用户组
     * @return 关于更新操作后的结果
     */
    ResultBody update(GroupReceiveBean groupReceiveBean);

    /**
     * 此方法用于删除已创建的组.
     *
     * @param groupReceiveBean 前台传入的搜索信息
     * @return 关于删除操作的结果
     */
    ResultBody delete(GroupReceiveBean groupReceiveBean);

    /**
     * 此方法用于获取组和组成员的信息.
     *
     * @param groupReceiveBean 该bean中仅包含用户id
     * @return 关于操作后的结果
     */
    ResultBody get(GroupReceiveBean groupReceiveBean);

    /**
     * 此方法用于列出所有用户组的成员和组的信息.
     *
     * @param receiveBean 前台传来的检索信息
     * @return 关于操作后的结果
     */
    ResultBody list(ReceiveBean receiveBean);

}
