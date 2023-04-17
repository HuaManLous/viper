package com.summary.hml.viper.jedis;

import com.aliyun.credentials.utils.StringUtils;
import com.summary.hml.viper.common.exception.BaseException;
import com.summary.hml.viper.common.exception.ErrorCode;
import redis.clients.jedis.Jedis;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-04-10 22:55
 * @Description : 秒杀案例
 */
public class SecKill {

    public static void main(String[] args) {
        secKill("199990111220","1010");
    }


    public static void secKill(String uid,String prodid){
        // 1.判断用户和商品ID是否正确
        if (StringUtils.isEmpty(uid) || StringUtils.isEmpty(prodid)) {
            throw new BaseException("登陆异常", ErrorCode.UNKNOWN_SYSTEM_EXCEPTION);
        }

        // 2.连接redis
        Jedis jedis = new Jedis("192.168.0.104", 6379);
        jedis.auth("215125");

        // 3.拼接key
        // 3.1库存key
        String kcKey = "sK:" + prodid + ":qt";
        // 3.2秒杀成功用户key
        String userKey = "sk:" + prodid + ":user";

        // 4.获取库存，如果库存为null，秒杀还么有开始
        String kc = jedis.get(kcKey);
        if (null == kc) {
            jedis.close();
            throw new BaseException("秒杀没有开始", ErrorCode.UNKNOWN_SYSTEM_EXCEPTION);
        }

        // 5.判断用户是否重复秒杀
        if (jedis.sismember(userKey, uid)) {
            jedis.close();
            throw new BaseException("不能重复秒杀", ErrorCode.UNKNOWN_SYSTEM_EXCEPTION);
        }

        // 6.判断如果商品数量，库存数量小于1，秒杀结束
        int i = Integer.parseInt(kc);
        if (i <= 0) {
            jedis.close();
            throw new BaseException("秒杀已经结束", ErrorCode.UNKNOWN_SYSTEM_EXCEPTION);
        }

        // 7.秒杀过程
        // 7.1库存-1
        jedis.decr(kcKey);
        // 7.2把秒杀成功用户添加清单里面
        jedis.sadd(userKey,uid);
        System.out.println("秒杀成功");
        jedis.close();



    }
}
