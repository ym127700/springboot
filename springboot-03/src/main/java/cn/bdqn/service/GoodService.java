package cn.bdqn.service;

import cn.bdqn.entity.Good;
import cn.bdqn.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GoodService {

     @Autowired
     GoodRepository goodRepository;

     //基本的分页加排序
    public List<Good> findAllByPage(){
        //创建排序
        Sort sort = Sort.by(Sort.Direction.DESC,"gprice");
        //创建的分页
        Pageable pageable = PageRequest.of(1-1,3,sort);

        Page<Good> all = goodRepository.findAll(pageable);
        //取出查询的集合
        List<Good> content = all.getContent();
        //取出查询的总页数
        int totalPages = all.getTotalPages();
        //取出查询的总条数
        long totalElements = all.getTotalElements();

        System.out.println("总页数:"+totalPages);
        System.out.println("总条数:"+totalElements);

        return content;
    }

    //简单的条件带分页
    public List<Good> findAllByPage2(){
        //创建排序
        Sort sort = Sort.by(Sort.Direction.DESC,"gprice");
        //创建的分页
        Pageable pageable = PageRequest.of(0,2,sort);

        Page<Good> all = goodRepository.findByGcount(100,pageable);

        //取出查询的集合
        List<Good> content = all.getContent();
        //取出查询的总页数
        int totalPages = all.getTotalPages();
        //取出查询的总条数
        long totalElements = all.getTotalElements();

        System.out.println("总页数:"+totalPages);
        System.out.println("总条数:"+totalElements);

        return content;
    }

    public List<Good> findAll(){
        return goodRepository.findAll();
     }

    public Good findByGid(Integer gid){
        Optional<Good> optional = goodRepository.findById(gid);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public Good save(Good good){
        Good save = goodRepository.save(good);
        return save;
    }

    public Good update(Good good){
        Good save = goodRepository.save(good);
        return save;
    }

    public void delete(Integer gid){
        goodRepository.deleteById(gid);
    }

    public List<Good> findByGnameLike(String gname,Integer gcount){
        return goodRepository.findByGnameLikeAndGcountLessThan(gname,gcount);
    }

    public List<Good> findByGname2(String name1,String name2){
        return goodRepository.findByGname2(name1,name2);
    }

    public List<Good> findByGname3(String name1,String name2){
        return goodRepository.findByGname3(name1,name2);
    }

    //复杂分页
    public  Page<Good> select(Map<String,Object> map){
        Integer currPage = (Integer)map.get("page");
        Integer size = (Integer)map.get("size");
        Pageable page = PageRequest.of(currPage-1,size);
        Specification<Good> specification = new Specification<Good>() {
            @Override
            public Predicate toPredicate(Root<Good> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> list = new ArrayList<>();
                if (map.get("gname")!=null){
                    Predicate p1 = criteriaBuilder.like(root.get("gname"),map.get("gname").toString());
                    list.add(p1);
                }
                if(map.get("minPrice")!=null){
                    Predicate p2 = criteriaBuilder.gt(root.get("gprice"),(Double)map.get("minPrice"));
                    list.add(p2);
                }
                if(map.get("maxPrice")!=null){
                    Predicate p3 = criteriaBuilder.lt(root.get("gprice"),(Double)map.get("maxPrice"));
                    list.add(p3);
                }
                if(map.get("tid")!=null){
                    Predicate p4 = criteriaBuilder.equal(root.get("tid"),(Integer)map.get("tid"));
                    list.add(p4);
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        //调用分页查询
        Page<Good> all = goodRepository.findAll(specification, page);
        //取出查询的集合
        List<Good> content = all.getContent();
        //取出查询的总页数
        int totalPages = all.getTotalPages();
        //取出查询的总条数
        long totalElements = all.getTotalElements();

        System.out.println("总页数:"+totalPages);
        System.out.println("总条数:"+totalElements);
        return all;
    }
}
