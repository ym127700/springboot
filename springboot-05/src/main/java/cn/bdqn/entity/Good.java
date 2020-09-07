package cn.bdqn.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class Good {

    @TableId(type = IdType.AUTO)
    private  Integer gid;

    private  String gname;

    private  Double gprice;

    private  Integer gcount;

    private  Integer tid;

    private  Date time;

    @Version
    private Integer version;

    @TableLogic(value = "0",delval = "1")
    private Integer status;

}
