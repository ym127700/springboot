package cn.bdqn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.Data;

@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    @TableField(condition = "%s>=#{%s}")
    private Integer age;


    @TableField(condition = SqlCondition.LIKE)
    private String email;


}
