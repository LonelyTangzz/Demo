package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.UserInfo;
import com.example.demo.bean.po.ReceiveBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Joker
 * @since 2020/8/27 19:38
 */
@Repository
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    int deleteByPrimaryKey(Long userid); // never used

    /**
     * 创建一个新的用户
     *
     * @param record 存储用户信息
     * @return 返回1表示成功，否则失败
     */
    int insertSelective(UserInfo record);

    /**
     * 根据用户主键查询用户
     *
     * @param userid 用户主键
     * @return 如此查询成功返回该用户信息，否则返回空
     */
    UserInfo selectByPrimaryKey(Long userid);

    /**
     * 更新{userId}等于{param}的用户信息.
     * 如果用户信息不完整，则仅更新现有参数
     *
     * @param record 用户信息
     * @return 返回1表示成功，否则失败
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * 此删除仅将标志设置为1，而不删除表中的相应记录
     *
     * @param userId     将被删除的用户
     * @param modifierId 执行此操作的用户
     * @return 返回1表示成功，否则失败
     */
    int deleteByModifierId(@Param(value = "userId") Long userId, @Param(value = "modifierId") Long modifierId);

    /**
     * 通过列表获取用户信息
     *
     * @param receiveBean 作为搜索存储消息的bean
     * @return 若存储返回一个用户信息列表，否则返回null
     */
    List<UserInfo> listUserInfo(ReceiveBean receiveBean);

    /**
     * 重置用户密码
     *
     * @param record 用户信息
     * @return 返回1表示成功，否则失败
     */
    int resetpwd(UserInfo record);
}