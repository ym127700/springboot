package cn.bdqn.mapper;

import cn.bdqn.entity.Good;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;


public interface GoodMapper extends BaseMapper<Good> {

    @Select("select * from good ${ew.customSqlSegment}")
    List<Good> selectUserSql(@Param(Constants.WRAPPER) Wrapper<Good> wrapper);

}
