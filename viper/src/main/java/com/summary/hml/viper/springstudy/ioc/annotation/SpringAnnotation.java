package com.summary.hml.viper.springstudy.ioc.annotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-23 12:16
 * @Description : 注解版
 */
@Service
public class SpringAnnotation {

    /**
     * spring 注解生成对象
     *     @Service
     *     @Controller
     *     @Repository
     *     @Component
     *
     */

    /**
     *
     * @Autowired  按照类型自动注入
     * @Qualifier  按照名称注入（必须和@Autowired一起使用）
     * @Resource   可以按照名称和类型注入  先按照名称注入，然后根据类型，如果都不行就报错
     * @Value      给普通属性注入
     *     1.不能作用于静态变量；
     *     2.不能作用于常量;
     *     3.不能在非注册的类中使用；
     *     4.使用这个类时，只能通过依赖注入的方式，用new的方式是不会自动注入这些配置的。
     *
     */

    //@Value(value = "张三")
    @Value("张三")
    private String name;

    //@Autowired  // 按照属性类型注入
    //@Qualifier(value = "springAnnotationDaoImpl")
    @Resource(name = "springAnnotationDaoImpl")
    private SpringAnnotationDao springAnnotationDao;

    public void add() {
        System.out.println("service ...." + name);
        springAnnotationDao.add();
    }

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocxml/SpringAnnotation.xml");
        SpringAnnotation springAnnotation = applicationContext.getBean("springAnnotation", SpringAnnotation.class);
        springAnnotation.add();
    }


}
