package cn.bdqn.test;

import cn.bdqn.entity.Good;
import cn.bdqn.service.GoodService;
import cn.bdqn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MpTest {

    @Autowired
    UserService userService;

    @Test
    public void  test1(){
        //userService.selectList();
        userService.findList();
    }

    @Test
    public void  test2(){
        userService.insert();
    }

    @Test
    public void  test3(){
        userService.findByIds();
    }

    @Test
    public void  test4(){
        userService.findByMap();
    }
    @Test
    public void  test5(){
        userService.findByWrapper();
    }
    @Test
    public void  test6(){
        userService.findByWrapper3();
    }

    @Autowired
    GoodService goodService;


    @Test
    public void  test7(){
        goodService.selectLambda();
    }
    @Test
    public void  test8(){
        goodService.update();
    }

    @Test
    public void  test9(){
        goodService.delete();
    }

    @Test
    public void test10(){
        List<Good> list = goodService.list(null);
        list.forEach(System.out::println);
    }

}
