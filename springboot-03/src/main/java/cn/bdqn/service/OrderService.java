package cn.bdqn.service;

import cn.bdqn.entity.Order;
import cn.bdqn.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public List<Order> selectAll(){
        return orderRepository.findAll();
    }

}
