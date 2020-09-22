package com.example.demo.controller;

import com.example.demo.bean.UserInfo;
import com.example.demo.bean.vo.ResultBody;
import com.example.demo.service.UserInfoService;
import com.example.demo.bean.po.ReceiveBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * status: 0 means normal,1 means error.
 * msg: a message about the status which happened.
 * data: storage return entries.
 *
 * @author Joker
 * @date 2020/8/13 15:19
 */
@RestController
public class UserInfoController {

    private UserInfoService userInfoService;

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * 新增用户信息
     *
     * @param userInfo 新增的用户信息
     * @return 返回新增后结果
     */
    @PostMapping(value = "user/save")
    public ResultBody save(@RequestBody UserInfo userInfo) {
        return userInfoService.save(userInfo);
    }

    /**
     * 更新用户信息
     *
     * @param userInfo 待更新的用户信息
     * @return 返回更新后结果
     */
    @PostMapping(value = "user/update")
    public ResultBody update(@RequestBody UserInfo userInfo) {
        return userInfoService.update(userInfo);
    }

    /**
     * 删除用户信息
     *
     * @param userInfo 待删除用户的id
     * @return 返回删除后结果
     */
    @PostMapping(value = "user/delete")
    public ResultBody delete(@RequestBody UserInfo userInfo) {
        return userInfoService.delete(userInfo.getUserid(), userInfo.getModifier());
    }

    /**
     * 根据用户id查询相应用户信息
     *
     * @param userInfo 用户id查询
     * @return 返回查询结果
     */
    @PostMapping(value = "user/get")
    public ResultBody get(@RequestBody UserInfo userInfo) {
        return userInfoService.getUser(userInfo.getUserid());
    }

    /**
     * 根据搜索关键字查询相关的所有用户信息
     *
     * @param receiveBean 接收的搜索信息
     * @return 返回列表查询结果
     */
    @PostMapping(value = "user/list")
    public ResultBody list(@RequestBody ReceiveBean receiveBean) {
        return userInfoService.listUsers(receiveBean);
    }

    /**
     * 根据用户的id修改相应用户的密码
     *
     * @param userInfo 包含所需修改用户id以及修改后的密码
     * @return 返回修改密码后结果
     */
    @PostMapping(value = "user/resetpwd")
    public ResultBody resetpwd(@RequestBody UserInfo userInfo) {
        return userInfoService.resetpwd(userInfo);
    }

}
