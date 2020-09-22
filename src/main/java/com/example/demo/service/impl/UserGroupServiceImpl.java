package com.example.demo.service.impl;

import com.example.demo.bean.UserConstants;
import com.example.demo.bean.UserGroup;
import com.example.demo.dao.UserGroupMapper;
import com.example.demo.enums.ResultCodeEnum;
import com.example.demo.bean.vo.ResultBody;
import com.example.demo.service.UserGroupMemberService;
import com.example.demo.service.UserGroupService;
import com.example.demo.tools.BeanCopierUtils;
import com.example.demo.bean.po.GroupReceiveBean;
import com.example.demo.bean.po.ReceiveBean;
import com.example.demo.bean.vo.UserGroupListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;


/**
 * @author Joker
 * @since 2020/8/28 9:57
 */
@Service
public class UserGroupServiceImpl implements UserGroupService {

    private UserGroupMapper userGroupMapper;

    @Autowired
    public void setUserGroupMapper(UserGroupMapper userGroupMapper) {
        this.userGroupMapper = userGroupMapper;
    }

    private UserGroupMemberService userGroupMemberService;

    @Autowired
    public void setUserGroupMemberService(UserGroupMemberService userGroupMemberService) {
        this.userGroupMemberService = userGroupMemberService;
    }

    @Override
    public Boolean userGroupExists(UserGroup userGroup) {
        return userGroupMapper.selectByPrimaryKey(userGroup.getUsergroupid()) != null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBody save(GroupReceiveBean groupReceiveBean) {
        UserGroup userGroup = new UserGroup();
        BeanCopierUtils.INSTANCE.copy(groupReceiveBean, userGroup);
        List<Long> userGroupMemberList = groupReceiveBean.getUserGroupIdList();
        if (StringUtils.isEmpty(userGroup.getUsergroupname())) {
            return UserConstants.PARAMETER_ERROR;
        }

        if (userGroupMapper.selectByGroupName(userGroup) != null) {
            return UserConstants.GROUP_EXIST;
        }

        if (userGroupMapper.insertSelective(userGroup) <= 0) {
            return UserConstants.INSERT_FAILED;
        }

        try {
            userGroupMemberService.save(userGroupMemberList, userGroup);
            return UserConstants.DEFAULT_SUCCESS;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return UserConstants.PARAMETER_ERROR;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBody update(GroupReceiveBean groupReceiveBean) {
        UserGroup userGroup = new UserGroup();
        List<Long> userGroupMemberList = groupReceiveBean.getUserGroupIdList();
        BeanCopierUtils.INSTANCE.copy(groupReceiveBean, userGroup);
        if (userGroup.getUsergroupid() == null || userGroup.getModifier() == null) {
            return UserConstants.PARAMETER_ERROR;
        }

        if (!this.userGroupExists(userGroup)) {
            return UserConstants.GROUP_UN_EXIST;
        }

        try {
            userGroupMemberService.deleteByUserGroupId(userGroup);
            userGroupMapper.updateByPrimaryKeySelective(userGroup);
            userGroupMemberService.save(userGroupMemberList, userGroup);
            return UserConstants.DEFAULT_SUCCESS;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResultBody(ResultCodeEnum.UPDATE_FAILED, null);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBody delete(GroupReceiveBean groupReceiveBean) {
        UserGroup userGroup = new UserGroup();
        BeanCopierUtils.INSTANCE.copy(groupReceiveBean, userGroup);
        if (userGroup.getUsergroupid() == null || userGroup.getModifier() == null) {
            return UserConstants.PARAMETER_ERROR;
        }

        if (!this.userGroupExists(userGroup)) {
            return UserConstants.GROUP_UN_EXIST;
        }

        try {
            userGroupMemberService.deleteByUserGroupId(userGroup);
            userGroupMapper.deleteByGroupId(userGroup);
            return UserConstants.DEFAULT_SUCCESS;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResultBody(ResultCodeEnum.DELETE_FAILED, null);
        }
    }

    @Override
    public ResultBody get(GroupReceiveBean groupReceiveBean) {
        Long userGroupId = groupReceiveBean.getUsergroupid();
        if (userGroupId == null) {
            return UserConstants.PARAMETER_ERROR;
        }

        UserGroup userGroup = userGroupMapper.selectByPrimaryKey(userGroupId);
        if (userGroup == null) {
            return UserConstants.GROUP_UN_EXIST;
        }

        HashMap<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("GroupInfo", userGroup);
        resultMap.put("GroupMemberInfo", userGroupMemberService.getMemberByGroupId(userGroupId).getData());
        return new ResultBody(ResultCodeEnum.BUILD_SUCCESS, resultMap);
    }

    @Override
    public ResultBody list(ReceiveBean receiveBean) {
        String type = receiveBean.getType();
        if (!StringUtils.isEmpty(type) && !UserConstants.ORDER.contains(type) && receiveBean.getPageNo() > 0 && receiveBean.getPageSize() > 0) {
            return UserConstants.PARAMETER_ERROR;
        }
        if (receiveBean.getPageNo() == null && receiveBean.getPageSize() == null) {
            return new ResultBody(ResultCodeEnum.BUILD_SUCCESS, userGroupMapper.listGroupAndMember(receiveBean));
        }

        List<UserGroupListVo> userGroupListVo = userGroupMapper.listGroupAndMember(receiveBean);
        if (userGroupListVo == null) {
            return new ResultBody(ResultCodeEnum.LIST_ERROR, null);
        }

        return new ResultBody(ResultCodeEnum.BUILD_SUCCESS, userGroupListVo);
    }
}
