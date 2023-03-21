package com.summary.hml.viper.spring_study.ioc.service;

import com.summary.hml.viper.spring_study.ioc.dao.UserDao;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-21 22:03
 * @Description : TODO
 */
public class UserService {

    // 注入外部bean
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("userService add..........");
        userDao.add();
    }


}
