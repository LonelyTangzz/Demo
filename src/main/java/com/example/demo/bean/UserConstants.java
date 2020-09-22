package com.example.demo.bean;

import com.example.demo.bean.vo.ResultBody;
import com.example.demo.enums.ResultCodeEnum;

import java.util.Arrays;
import java.util.List;

/**
 * @author Joker
 * @since 2020/8/27 15:42
 */
public interface UserConstants {

    /**
     * Order command,included asc and desc.
     */
    List<String> ORDER = Arrays.asList("ASC", "asc", "DESC", "desc");

    /**
     * the error when inserting but the group has been existed.
     */
    ResultBody GROUP_UN_EXIST = new ResultBody(ResultCodeEnum.GROUP_UN_EXIST, null);

    /**
     * default failed about user input wrong parameters.
     */
    ResultBody PARAMETER_ERROR = new ResultBody(ResultCodeEnum.PARAMETER_ERROR, null);

    /**
     * default success response without data.
     */
    ResultBody DEFAULT_SUCCESS = new ResultBody(ResultCodeEnum.BUILD_SUCCESS, null);

    /**
     * the error when inserting but the operate of inserting is failed.
     */
    ResultBody INSERT_FAILED = new ResultBody(ResultCodeEnum.INSERT_FAILED, null);

    /**
     * the error when saving the group but this group has been existed.
     */
    ResultBody GROUP_EXIST = new ResultBody(ResultCodeEnum.GROUP_EXIST, null);

    /**
     * the error when deleting but the operate of deleting is failed.
     */
    ResultBody DELETE_FAILED = new ResultBody(ResultCodeEnum.DELETE_FAILED, null);

    /**
     * this messages means user doesn't exist.
     */
    ResultBody USER_UN_EXIST = new ResultBody(ResultCodeEnum.USER_UN_EXIST, null);
    /**
     * this messages means update failed
     */
    ResultBody UPDATE_FAILED = new ResultBody(ResultCodeEnum.UPDATE_FAILED, null);
}
