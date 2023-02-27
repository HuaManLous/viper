package com.summary.hml.viper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//  扫描mapper路径
@MapperScan("com.summary.hml.viper.ssm.mapper")
public class ViperApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViperApplication.class, args);
    }

}
