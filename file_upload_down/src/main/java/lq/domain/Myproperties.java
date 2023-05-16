package lq.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:test.properties")
@EnableConfigurationProperties(Myproperties.class)
@ConfigurationProperties(prefix = "test")
public class Myproperties {
    private Long id;
    private String name;
}
