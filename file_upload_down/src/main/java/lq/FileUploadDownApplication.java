package lq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "lq.mapper")
public class FileUploadDownApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadDownApplication.class, args);
    }

}
