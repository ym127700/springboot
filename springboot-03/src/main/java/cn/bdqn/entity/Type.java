package cn.bdqn.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    private String tname;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "tid")
    private List<Good> goods;

}
