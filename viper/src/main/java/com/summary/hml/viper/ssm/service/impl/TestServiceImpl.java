package com.summary.hml.viper.ssm.service.impl;

import com.summary.hml.viper.ssm.mapper.TestMapper;
import com.summary.hml.viper.ssm.mapper.tree_mapper.SingleTableTreeMapper;
import com.summary.hml.viper.ssm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-02-27 16:56
 * @Description : TODO
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private SingleTableTreeMapper treeMapper;

    @Override
    public String getById(String id) {

        String byId = treeMapper.getById(id);
        System.out.println("配置文件版本 = " + byId);

        String byId1 = testMapper.getById(id);
        System.out.println("注解版本 = " + byId1);
        return byId + "+***+" + byId1;
    }
}
