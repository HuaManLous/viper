package com.summary.hml.viper.jedis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-11-04 10:36
 * @Description : TODO
 */
public class JedisDemoOne {

    public static void main(String[] args) {
        // 创建Jedis的对象
        Jedis jedis = new Jedis("172.21.64.184",6379);
        // 账号密码
        jedis.auth("215125");
        // 测试是否连接成功
        String ping = jedis.ping();
        System.out.println(ping);
        // 通过jedis操作redis
        jedis.set("XC","KU");
        String xc = jedis.get("XC");
        System.out.println(xc);
        // 设置过期时间
        jedis.expire("XC", 10);

        // mset mget
        jedis.mset("k1","v1","k2","v2");
        List<String> mget = jedis.mget("k1", "k2");
        mget.forEach(a -> {
            System.out.println(a);
        });
        Long xc1 = jedis.ttl("XC");
        System.out.println(xc1);



    }
}
