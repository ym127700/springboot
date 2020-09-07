package cn.bdqn.service;

import cn.bdqn.entity.User;
import cn.bdqn.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

      @Autowired
      UserMapper userMapper;

      public  void  selectList(){
          List<User> users = userMapper.selectList1();
          users.forEach(System.out::println);
      }

    public  void  findList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    public  void  findByIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 5));
        users.forEach(System.out::println);
    }

    public  void  findByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("age",20);
        map.put("email","@baomidou.com");

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    public  void  findByWrapper(){
        QueryWrapper queryWrapper = new QueryWrapper();
        //指定排序
        queryWrapper.orderByAsc("age");
        //指定查询部分列
        queryWrapper.select("age","id");
        //queryWrapper.like("email","baomidou.com");
        //queryWrapper.gt("age",20);
         //查询  年龄大于 20岁  或者  年龄大于 18岁并且 邮箱里面带 baomidou.com
        //queryWrapper.or();
        //queryWrapper.gt("age",18);
        //queryWrapper.like("email","baomidou.com");
        User user = new User();
        user.setEmail("baomidou.com");
        user.setAge(18);
        queryWrapper.setEntity(user);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

      public  void  findByWrapper2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.gt("age",20)
                .or(wq->wq.gt("age",18).like("email","baomidou.com"));
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    public  void  findByWrapper3(){
        Map<String,Object> map = new HashMap<>();
        map.put("age",20);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt(map.containsKey("age"),"age",map.get("age"));
        queryWrapper.like(map.containsKey("email"),"email",map.get("email"));
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }






    public  void  insert(){
        User user = new User();
        user.setAge(18);
        user.setName("zhikang Chi");
        user.setEmail("43241@@qq.com");

        int num = userMapper.insert(user);
        System.out.println(num);
    }


}
