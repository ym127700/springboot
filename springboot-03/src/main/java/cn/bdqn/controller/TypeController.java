package cn.bdqn.controller;

import cn.bdqn.entity.Order;
import cn.bdqn.entity.Type;
import cn.bdqn.service.OrderService;
import cn.bdqn.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {
    @Autowired
    TypeService typeService;

    @Autowired
    OrderService orderService;

    @GetMapping("/type/{tid}")
    public Type getType(@PathVariable Integer tid){

            return typeService.getType(tid);
    }

    @GetMapping("/order/list")
    public List<Order> getOrder(){
        return orderService.selectAll();
    }


}
