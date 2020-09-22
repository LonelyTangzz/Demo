package com.example.demo.bean.po;

import lombok.Data;

/**
 * @author Joker
 * @since 2020/8/27 15:49
 */
@Data
public class ReceiveBean {

    private String searchKey;

    private Integer pageNo;

    private Integer pageSize;

    private String field;

    private String type;

}
