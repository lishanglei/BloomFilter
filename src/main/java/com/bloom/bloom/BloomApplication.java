package com.bloom.bloom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
@MapperScan(basePackages = "com.bloom.bloom.com.bloom.guava.dao")
public class BloomApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloomApplication.class, args);
    }

}
