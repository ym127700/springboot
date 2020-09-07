package cn.bdqn.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "good")
@Data
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer gid;

    private  String gname;

    private  Double gprice;

    private  Integer gcount;

    private  Date time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tid")
    @JsonIgnore
    private  Type type;



}
