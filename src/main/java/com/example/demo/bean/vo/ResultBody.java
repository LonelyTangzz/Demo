package com.example.demo.bean.vo;

import com.example.demo.enums.ResultCodeEnum;
import lombok.Data;

/**
 * @author Joker
 * @since 2020/8/18 11:34
 */
@Data
public class ResultBody {

    private Object data;

    private ResultCodeEnum resultCodeEnum;

    public ResultBody(ResultCodeEnum code, Object data) {
        this.resultCodeEnum = code;
        this.data = data;
    }
}
