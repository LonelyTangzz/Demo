package com.example.demo.service.impl;

import com.example.demo.bean.UserConstants;
import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoMapper;
import com.example.demo.enums.ResultCodeEnum;
import com.example.demo.bean.vo.ResultBody;
import com.example.demo.service.UserInfoService;
import com.example.demo.bean.po.ReceiveBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author Joker
 * @since 2020/8/28 9:47
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoMapper userInfoMapper;

    @Autowired
    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }


    @Override
    public ResultBody save(UserInfo userInfo) {
        if (userInfoMapper.selectByPrimaryKey(userInfo.getUserid()) != null) {
            return new ResultBody(ResultCodeEnum.USER_EXIST, null);
        }

        return userInfoMapper.insertSelective(userInfo) > 0 ?
                UserConstants.DEFAULT_SUCCESS : new ResultBody(ResultCodeEnum.INSERT_FAILED, null);
    }

    @Override
    public ResultBody update(UserInfo userInfo) {
        if (userInfo.getUserid() == null || userInfo.getUserid() == 0) {
            return UserConstants.PARAMETER_ERROR;
        }

        if (this.checkUser(userInfo.getUserid())) {
            return UserConstants.USER_UN_EXIST;
        }

        if (userInfo.getModifier() == null) {
            userInfo.setModifier(userInfo.getUserid());
        }

        userInfo.setModifytime(new Date());
        return userInfoMapper.updateByPrimaryKeySelective(userInfo) > 0 ?
                UserConstants.DEFAULT_SUCCESS : UserConstants.UPDATE_FAILED;
    }

    @Override
    public ResultBody delete(Long id, Long modifier) {
        boolean existsUser = this.checkUser(id);
        boolean existsModifier = this.checkUser(modifier);
        if (!existsUser || !existsModifier) {
            return UserConstants.PARAMETER_ERROR;
        }

        return userInfoMapper.deleteByModifierId(id, modifier) > 0 ? UserConstants.DEFAULT_SUCCESS :
                UserConstants.DELETE_FAILED;
    }

    @Override
    public ResultBody getUser(Long id) {
        if (id == null || id == 0) {
            return UserConstants.PARAMETER_ERROR;
        }

        if (this.checkUser(id)) {
            return UserConstants.USER_UN_EXIST;
        }

        return new ResultBody(ResultCodeEnum.BUILD_SUCCESS, userInfoMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResultBody listUsers(ReceiveBean receiveBean) {
        String type = receiveBean.getType();
        if (!StringUtils.isEmpty(type) && !UserConstants.ORDER.contains(type)) {
            return UserConstants.PARAMETER_ERROR;
        }

        if (receiveBean.getPageNo() == null && receiveBean.getPageSize() == null) {
            return new ResultBody(ResultCodeEnum.BUILD_SUCCESS, userInfoMapper.listUserInfo(receiveBean));
        }

        if ((receiveBean.getPageNo() > 0 && receiveBean.getPageSize() > 0)) {
            return new ResultBody(ResultCodeEnum.BUILD_SUCCESS, userInfoMapper.listUserInfo(receiveBean));
        }

        return UserConstants.PARAMETER_ERROR;
    }

    @Override
    public ResultBody resetpwd(UserInfo userInfo) {
        if (userInfo.getUserid() == null || userInfo.getUserid() == 0) {
            return UserConstants.PARAMETER_ERROR;
        }

        boolean existsUser = this.checkUser(userInfo.getUserid());
        if (!existsUser) {
            return UserConstants.USER_UN_EXIST;
        }

        if (userInfo.getModifier() == null) {
            userInfo.setModifier(userInfo.getUserid());
        }

        return userInfoMapper.resetpwd(userInfo) > 0 ? UserConstants.DEFAULT_SUCCESS : UserConstants.UPDATE_FAILED;
    }

    @Override
    public boolean checkUser(Long id) {
        return userInfoMapper.selectByPrimaryKey(id) != null;
    }
}
