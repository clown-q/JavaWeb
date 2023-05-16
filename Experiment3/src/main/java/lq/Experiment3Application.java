package lq;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("lq.mapper")
public class Experiment3Application {

    public static void main(String[] args) {
        SpringApplication.run(Experiment3Application.class, args);
    }

}
