package cn.bdqn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
@Import(StudentProperties.class)
public class MyConfig{
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
