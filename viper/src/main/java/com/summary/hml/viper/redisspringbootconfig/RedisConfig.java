package com.summary.hml.viper.redisspringbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-11-04 16:12
 * @Description : TODO
 */
public class RedisConfig {


    @Autowired
    private RedisTemplate redisTemplate;

    public String testRedis() {
        redisTemplate.opsForValue().set("key", "22");
        return redisTemplate.opsForValue().get("key").toString();
    }


}
