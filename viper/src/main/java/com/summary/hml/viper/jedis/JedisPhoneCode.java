package com.summary.hml.viper.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2021-11-04 11:43
 * @Description : 通过redis实现手机验证码验证
 */
public class JedisPhoneCode {

    /*
    * 1.输入手机号后，点击发送后随机生成6位数字验证码，过期时间2分钟
    * 2.输入验证码后，点击验证，返回成功或者失败
    * 3.每个手机号，每天只能发送三次
    * */

    public static void main(String[] args) {
        String codeByPhone = getCodeByPhone("18338354114");
        System.out.println(codeByPhone);
        //boolean prove = prove("18338354114", codeByPhone);
        //System.out.println(prove);
    }



    // 1.生成随机六位数
    public static Integer getSixCode(){

        // double random1 = Math.random(); 产生【0，1）的double类型的数
        // Math.random() * (m - n) + n;产生【n,m）
        // 000000 999999
        Random random = new Random();
        int i = random.nextInt(999999);
        return i;
    }
    
    // 2.通过手机号获取验证码
    public static String getCodeByPhone(String phone){
        Jedis jedis = new Jedis("172.21.64.184",6379);
        jedis.auth("215125");
        String code = getSixCode().toString();
        if (null != jedis.get("phone:count") && Integer.parseInt(jedis.get("phone:count")) >= 3) {
            return "今日验证码已经超过三次";
        }
        if (null == jedis.get("phone:count")) {
            jedis.setex("phone:count",24*60*60,"1");
        }else {
            jedis.incr("phone:count");
        }
        jedis.setex(phone,120,code);
        return code;
    }

    // 3.通过手机号，验证码判断是否正确
    public static boolean prove(String phone,String code){
        Jedis jedis = new Jedis("172.21.64.184",6379);
        jedis.auth("215125");
        String sixCode = jedis.get(phone);
        if (null != code && code.equals(sixCode)) {
            return true;
        }
        return false;
    }









}
