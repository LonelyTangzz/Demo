package com.example.demo.controller;

import com.example.demo.bean.vo.ResultBody;
import com.example.demo.service.UserGroupService;
import com.example.demo.bean.po.GroupReceiveBean;
import com.example.demo.bean.po.ReceiveBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joker
 * @date 2020/8/20 16:39
 * <p>
 * 用户组控制器
 */
@RestController
public class UserGroupController {

    private UserGroupService userGroupService;

    @Autowired
    public void setUserGroupService(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    /**
     * 新增用户组及用户组下的组员.
     *
     * @param groupReceiveBean 接受到的新增用户组信息
     * @return 返回新增后结果
     */
    @PostMapping(value = "usergroup/save")
    public ResultBody save(@RequestBody GroupReceiveBean groupReceiveBean) {
        return userGroupService.save(groupReceiveBean);
    }

    /**
     * 更新该用户组信息及组内成员信息.
     *
     * @param groupReceiveBean 所需更新的用户组信息
     * @return 返回更新后结果
     */
    @PostMapping(value = "usergroup/update")
    public ResultBody update(@RequestBody GroupReceiveBean groupReceiveBean) {
        return userGroupService.update(groupReceiveBean);
    }

    /**
     * 用于删除用户组，并将其中组员清空.
     *
     * @param groupReceiveBean 删除的用户组（仅包含id)
     * @return 返回删除后结果
     */
    @PostMapping(value = "usergroup/delete")
    public ResultBody delete(@RequestBody GroupReceiveBean groupReceiveBean) {
        return userGroupService.delete(groupReceiveBean);
    }

    /**
     * 根据用户组id获取单个用户组信息及用户组下成员.
     *
     * @param groupReceiveBean 用户组id
     * @return 返回查找后结果
     */
    @PostMapping(value = "usergroup/get")
    public ResultBody get(@RequestBody GroupReceiveBean groupReceiveBean) {
        return userGroupService.get(groupReceiveBean);
    }

    /**
     * 根据用户组名字排序并返回一个列表
     *
     * @param receiveBean 检索信息
     * @return 返回检索结果
     */
    @PostMapping(value = "usergroup/list")
    public ResultBody list(@RequestBody ReceiveBean receiveBean) {
        return userGroupService.list(receiveBean);
    }

}
