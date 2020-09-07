package cn.bdqn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.bdqn.mapper")
public class App5 {

    public static void main(String[] args) {
        SpringApplication.run(App5.class,args);
    }
}
