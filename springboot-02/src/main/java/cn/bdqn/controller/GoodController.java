package cn.bdqn.controller;

import cn.bdqn.entity.Good;
import cn.bdqn.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodController {

    @Autowired
    GoodService goodService;

    @GetMapping("/good/list")
    public List<Good> selectAll(){
        return goodService.selectAll();
    }

}
