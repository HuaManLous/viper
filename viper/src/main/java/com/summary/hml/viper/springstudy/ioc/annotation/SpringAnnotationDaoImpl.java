package com.summary.hml.viper.springstudy.ioc.annotation;

import org.springframework.stereotype.Repository;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-23 12:39
 * @Description : TODO
 */
@Repository
public class SpringAnnotationDaoImpl implements SpringAnnotationDao{


    @Override
    public void add() {
        System.out.println("daoImpl .......");
    }
}
