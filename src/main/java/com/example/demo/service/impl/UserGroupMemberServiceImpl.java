package com.example.demo.service.impl;

import com.example.demo.bean.UserConstants;
import com.example.demo.bean.UserGroup;
import com.example.demo.dao.UserGroupMemberMapper;
import com.example.demo.enums.ResultCodeEnum;
import com.example.demo.bean.vo.ResultBody;
import com.example.demo.service.UserGroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joker
 * @since 2020/8/28 9:47
 */
@Service
public class UserGroupMemberServiceImpl implements UserGroupMemberService {

    private UserGroupMemberMapper userGroupMemberMapper;

    @Autowired
    public void setUserGroupMemberMapper(UserGroupMemberMapper userGroupMemberMapper) {
        this.userGroupMemberMapper = userGroupMemberMapper;
    }

    @Override
    public ResultBody save(List<Long> userGroupMemberList, UserGroup userGroup) {
        boolean res = userGroupMemberMapper.insertListMember(userGroupMemberList, userGroup) > 0;
        if (res) {
            return UserConstants.DEFAULT_SUCCESS;
        }

        return UserConstants.INSERT_FAILED;
    }

    @Override
    public ResultBody deleteByUserGroupId(UserGroup userGroup) {
        boolean res = userGroupMemberMapper.deleteByUserGroupId(userGroup) > 0;
        if (!res) {
            return UserConstants.DELETE_FAILED;
        }

        return UserConstants.DEFAULT_SUCCESS;
    }

    @Override
    public ResultBody getMemberByGroupId(Long userGroupId) {
        return new ResultBody(ResultCodeEnum.BUILD_SUCCESS, userGroupMemberMapper.selectByGroupId(userGroupId));
    }
}
