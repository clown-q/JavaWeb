package lq.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
public class Person2 {
    @Value("${person.id}")
    private Long id;
    @Value("${person.name}")
    private String name;
    private List<String> hobby;
    private Map<String,Object> map;
}
