package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Joker
 * @since 2020/8/27 19:38
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResultCodeEnum {

    BUILD_SUCCESS(0, "Build Success"),
    USER_EXIST(1, "User has be existed"),
    USER_UN_EXIST(1, "User hasn't existed"),
    INSERT_FAILED(1, "Insert Failed"),
    UPDATE_FAILED(1, "Update Failed"),
    DELETE_FAILED(1, "Delete Failed"),
    PARAMETER_ERROR(1, "Parameter Error"),
    GROUP_EXIST(1, "Group has be existed"),
    GROUP_UN_EXIST(1, "Group hasn't existed"),
    LIST_ERROR(1, "Group list failed");

    private final Integer status;
    private final String msg;

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    ResultCodeEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
