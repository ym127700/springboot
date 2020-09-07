package cn.bdqn.repository;

import cn.bdqn.entity.Good;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface GoodRepository extends JpaRepository<Good,Integer>, JpaSpecificationExecutor<Good> {

    List<Good> findByGnameLike(String gname);

    List<Good> findByGnameLikeAndGcountLessThan(String gname,Integer gcount);

    Page<Good> findByGcount(Integer gcount, Pageable pageable);

    @Query("from Good o where o.gname like :name1 or o.gname like :name2")
    List<Good> findByGname2(String name1,String name2);

    @Query(nativeQuery = true,value = "select * from good where gname like :name1 or gname like :name2")
    List<Good> findByGname3(String name1,String name2);

}
