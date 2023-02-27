package com.summary.hml.viper.ssm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-02-27 16:59
 * @Description : TestMapper
 */

@Mapper
public interface TestMapper {

    @Select("select name from user where id = #{id}")
    String getById(String id);
}
