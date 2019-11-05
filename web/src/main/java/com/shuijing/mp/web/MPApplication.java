package com.shuijing.mp.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liushuijing (shuijing@shanshu.ai)
 * @date 2019/11/05
 */

@SpringBootApplication(scanBasePackages = "com.shuijing.mp")
@MapperScan("com.shuijing.mp.dao.mapper")
public class MPApplication {

    public static void main(String[] args) {
        SpringApplication.run(MPApplication.class, args);
    }

}
