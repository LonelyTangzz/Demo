package com.example.demo.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;



/**
 * @author Joker
 * @since 2020/9/14 20:07
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode
@ApiModel(value = "TestClass",description = "测试用例")
public class TestClass {
    private Integer id;
    private String name;
}
