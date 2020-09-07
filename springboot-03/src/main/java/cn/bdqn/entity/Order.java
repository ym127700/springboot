package cn.bdqn.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

    private String oinfo;

    private Date otime;

    private Integer osid;

    private Integer aid;

    private Double omoney;

    @ManyToMany
    @JoinTable(
        name = "odetails",
        joinColumns = @JoinColumn(name = "oid",referencedColumnName = "oid"),
        inverseJoinColumns = @JoinColumn(name = "gid",referencedColumnName = "gid")
    )
    private List<Good> goods;

}
