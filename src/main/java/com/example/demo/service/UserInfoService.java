package com.example.demo.service;

import com.example.demo.bean.UserInfo;
import com.example.demo.bean.vo.ResultBody;
import com.example.demo.bean.po.ReceiveBean;


/**
 * @author Joker
 * @since 2020/8/27 20:45
 */
public interface UserInfoService {

    /**
     * 将用户插入用户信息表
     *
     * @param userInfo 用户信息
     * @return 有关操作的状态消息
     */
    ResultBody save(UserInfo userInfo);

    /**
     * 检查用户是否存在
     *
     * @param id 用于验证的用户id
     * @return 存在返回true, 不存在返回false
     */
    boolean checkUser(Long id);

    /**
     * 更新用户信息
     *
     * @param userInfo 新用户信息
     * @return 返回操作后结果
     */
    ResultBody update(UserInfo userInfo);

    /**
     * 只需将table属性的flag更改为1，
     * 就可以删除信息并保留用户信息记录。
     *
     * @param id       待删除用户的id
     * @param modifier 操作人id
     * @return 返回操作后结果
     */
    ResultBody delete(Long id, Long modifier);

    /**
     * 通过用户id查找用户.
     *
     * @param id 用户id
     * @return 如果成功则返回userInfo实体，否则返回null
     */
    ResultBody getUser(Long id);

    /**
     * 返回用户信息表。
     *
     * @param receiveBean 用于存储搜索消息的bean
     * @return 返回空或相关的所有用户信息
     */
    ResultBody listUsers(ReceiveBean receiveBean);

    /**
     * 重置用户密码
     *
     * @param userInfo 存放待修改用户id、新密码及修改人员的id
     * @return 返回操作后结果
     */
    ResultBody resetpwd(UserInfo userInfo);
}
