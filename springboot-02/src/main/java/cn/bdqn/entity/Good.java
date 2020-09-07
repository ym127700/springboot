package cn.bdqn.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * good
 * @author 
 */
@Data
public class Good implements Serializable {
    /**
     * 商品编号
     */
    private Integer gid;

    /**
     * 商品名称
     */
    private String gname;

    /**
     * 商品价格
     */
    private Double gprice;

    /**
     * 商品数量
     */
    private Integer gcount;

    /**
     * 商品类型编号
     */
    private Integer tid;

    private Date time;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Good other = (Good) that;
        return (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getGname() == null ? other.getGname() == null : this.getGname().equals(other.getGname()))
            && (this.getGprice() == null ? other.getGprice() == null : this.getGprice().equals(other.getGprice()))
            && (this.getGcount() == null ? other.getGcount() == null : this.getGcount().equals(other.getGcount()))
            && (this.getTid() == null ? other.getTid() == null : this.getTid().equals(other.getTid()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getGname() == null) ? 0 : getGname().hashCode());
        result = prime * result + ((getGprice() == null) ? 0 : getGprice().hashCode());
        result = prime * result + ((getGcount() == null) ? 0 : getGcount().hashCode());
        result = prime * result + ((getTid() == null) ? 0 : getTid().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gid=").append(gid);
        sb.append(", gname=").append(gname);
        sb.append(", gprice=").append(gprice);
        sb.append(", gcount=").append(gcount);
        sb.append(", tid=").append(tid);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}