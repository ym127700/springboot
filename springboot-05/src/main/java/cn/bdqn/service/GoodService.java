package cn.bdqn.service;

import cn.bdqn.entity.Good;
import cn.bdqn.mapper.GoodMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodService extends ServiceImpl<GoodMapper,Good>{

    @Autowired
    GoodMapper mapper;

    public void selectGroup(){
        QueryWrapper<Good> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("tid","count(0) as count","avg(gprice) as avg","sum(gcount) as sum");
        queryWrapper.groupBy("tid");
        queryWrapper.having("avg(gprice)>{0}",10);

        List<Map<String, Object>> list = mapper.selectMaps(queryWrapper);
        list.forEach(System.out::println);
    }


    public void selectLambda(){
        LambdaQueryWrapper<Good> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Good::getGname,"茶");
        lambdaQueryWrapper.gt(Good::getGprice,10);

        Page<Good> goodPage = mapper.selectPage(new Page<Good>(1, 3), lambdaQueryWrapper);

        List<Good> records = goodPage.getRecords();
        System.out.println("总条数:"+goodPage.getTotal());
        System.out.println("总页数:"+goodPage.getPages());
    }


    public void selectSql(){
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.like("gname","茶");
        List<Good> goods = mapper.selectUserSql(wrapper);
        goods.forEach(System.out::println);
    }

    public void delete(){
        int i = mapper.deleteById(13);
        System.out.println(i);
    }



}
