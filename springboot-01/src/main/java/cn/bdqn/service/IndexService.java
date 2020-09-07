package cn.bdqn.service;

import cn.bdqn.config.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
//@EnableConfigurationProperties(value = StudentProperties.class)
public class IndexService {
    @Autowired
    StudentProperties studentProperties;



    public StudentProperties getStudent(){
        studentProperties.setName("吴杰");

        return studentProperties;
    }

}
