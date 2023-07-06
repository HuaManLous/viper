package com.summary.hml.viper.springstudy.aop.jdbctemplate;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-03-25 12:06
 * @Description : TODO
 */
public class JdbcTemplateTest {
    
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocxml/JdbcTemplate.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        DruidDataSource druidDataSource = applicationContext.getBean("dataSource", DruidDataSource.class);
        System.out.println("druidDataSource = " + druidDataSource);

        // jdbc删除数据
        // int delNum = jdbcTemplate.update("delete from user where id = ?",1);
        // jdbc新增数据
        //jdbcTemplate.update("insert into user(name,age) value(?,?)","花满楼",18);
        // jdbc修改数据
        //jdbcTemplate.update("update user set name = ? where id = 29","花满楼29");
        // jdbc查询数据
        // Map<String, Object>
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap("select * from user where id = 29");
        System.out.println("stringObjectMap = " + stringObjectMap);
        // List<Map<String, Object>>
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        System.out.println("maps = " + maps);
        // JdbcTemplateDo
        JdbcTemplateDo jdbcTemplateDo = jdbcTemplate.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<JdbcTemplateDo>(JdbcTemplateDo.class),29);
        System.out.println("jdbcTemplateDo = " + jdbcTemplateDo);
        // list<JdbcTemplateDo>
        List<JdbcTemplateDo> query = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<JdbcTemplateDo>(JdbcTemplateDo.class));
        System.out.println("query = " + query);

        // jdbc 批量添加操作
        /*List<Object[]> listArrAdd = new ArrayList<>();
        listArrAdd.add(new String[]{"花满楼291","19"});
        listArrAdd.add(new String[]{"花满楼2912","20"});
        jdbcTemplate.batchUpdate("insert into user(name,age) value(?,?)", listArrAdd);*/

        // jdbcTemplate 批量修改
        /*List<Object[]> listArrUpdate = new ArrayList<>();
        listArrUpdate.add(new String[]{"花满楼291up","19", "30"});
        listArrUpdate.add(new String[]{"花满楼2912up","20","31"});
        jdbcTemplate.batchUpdate("update user set name = ?, age = ? where id = ?", listArrUpdate);*/

        // jdbcTemplate 批量删除
        /*List<Object[]> listArrDelete = new ArrayList<>();
        listArrDelete.add(new String[]{"30"});
        listArrDelete.add(new String[]{"31"});
        jdbcTemplate.batchUpdate("delete from user where id = ?", listArrDelete);*/

    }
}
