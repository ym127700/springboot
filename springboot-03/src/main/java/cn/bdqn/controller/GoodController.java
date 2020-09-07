package cn.bdqn.controller;

import cn.bdqn.entity.Good;
import cn.bdqn.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GoodController {
    @Autowired
    GoodService goodService;

    @GetMapping("/good/list")
    public List<Good> findAll(){
        return goodService.findAll();
    }

    @GetMapping("/good/page1")
    public Page<Good> select(){
        Map<String,Object> map = new HashMap<>();
        map.put("gname","%茶%");
        map.put("minPrice",8.0);
        map.put("page",1);
        map.put("size",3);
        return goodService.select(map);
    }




    @GetMapping("/good/page")
    public List<Good> findAllByPage(){
        return goodService.findAllByPage2();
    }

    @GetMapping("/good/gname2")
    public List<Good> findByGname2(){
        return goodService.findByGname2("%茶%","%机%");
    }
    @GetMapping("/good/gname3")
    public List<Good> findByGname3(){
        return goodService.findByGname3("%茶%","%机%");
    }

    @GetMapping("/good/gname/{gname}")
    public List<Good> findByGname(@PathVariable String gname){
        return goodService.findByGnameLike("%"+gname+"%",100 );
    }



    @GetMapping("/good/{gid}")
    public ResponseEntity findByGid(@PathVariable Integer gid){
        return ResponseEntity.ok().body(goodService.findByGid(gid));
    }
    @PostMapping("/good")
    public ResponseEntity save(@RequestBody Good good){
        return ResponseEntity.ok().body(goodService.save(good));
    }

    @PutMapping("/good")
    public ResponseEntity update(@RequestBody Good good){
        return  ResponseEntity.ok().body(goodService.save(good));
    }

    @DeleteMapping("/good/{gid}")
    public ResponseEntity delete(@PathVariable Integer gid){
        goodService.delete(gid);
        return ResponseEntity.ok().build();
    }
}
