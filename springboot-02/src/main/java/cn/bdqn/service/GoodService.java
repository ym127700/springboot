package cn.bdqn.service;

import cn.bdqn.entity.Good;
import cn.bdqn.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {

    @Autowired
    GoodMapper mapper;

    public List<Good> selectAll(){
        return  mapper.selectByExample(null);
    }


    public Good selectByGid(int gid) {
         System.out.println("查询了数据库");
         return mapper.selectByPrimaryKey(gid);
    }

    public int delete(Integer gid) {
        return mapper.deleteByPrimaryKey(gid);
    }
}
