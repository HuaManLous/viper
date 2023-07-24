package com.summary.hml.viper.springstudy.ioc.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-22 00:00
 * @Description : TODO
 */
public class SpringIocCollections {

    private String[] arr;

    private List<String> list;

    private Map<String,String> map;

    private Set<String> set;

    private List<Dept> deptList;

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @Test
    public void test() {

        // 加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocxml/Collections.xml");
        SpringIocCollections springIocCollections = applicationContext.getBean("collections", SpringIocCollections.class);
        // set 无序不可重复 可存null值
        System.out.println("springIocCollections = " + JSON.toJSONString(springIocCollections, SerializerFeature.WriteNullStringAsEmpty));

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("iocxml/CollectionsTiQu.xml");
        SpringIocCollections springIocCollectionsTiQu = beanFactory.getBean("springIocCollectionsTiQu", SpringIocCollections.class);
        System.out.println("springIocCollectionsTiQu = " + JSON.toJSONString(springIocCollectionsTiQu, SerializerFeature.WriteNullStringAsEmpty));
    }
}
