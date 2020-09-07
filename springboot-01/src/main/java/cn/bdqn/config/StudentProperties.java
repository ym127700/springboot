package cn.bdqn.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties(prefix = "student")
@Data
public class StudentProperties {
    private String name;
    private Integer age;
    private String address;

}
