package com.summary.hml.viper.single_table_tree.tree_mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-12-27 15:42
 * @Description : TODO
 */
@Repository
public interface SingleTableTreeMapper {


    List<Map<String, Object>> getSingleTableTree(String configType);

}
