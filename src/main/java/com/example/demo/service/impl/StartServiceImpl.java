package com.example.demo.service.impl;

import com.example.demo.bean.po.ReceiveBean;
import com.example.demo.service.UserGroupService;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Joker
 * @since 2020/8/28 11:40
 */
//@Component
@Order(value = 1)
public class StartServiceImpl implements ApplicationRunner {

    UserInfoService userInfoService;

    UserGroupService userGroupService;

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Autowired
    public void setUserGroupService(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    private static final String cronSycn = "0 */5 * * *  ?";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ReceiveBean receiveBean = new ReceiveBean();
        System.out.println(userInfoService.listUsers(receiveBean));
    }

    @Scheduled(cron = cronSycn)
    public void selectAll() {
        ReceiveBean receiveBean = new ReceiveBean();
        System.out.println(userInfoService.listUsers(receiveBean));
        System.out.println(userGroupService.list(receiveBean));
    }
}
