package org.example.ecommerce.service;

import org.example.ecommerce.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.ecommerce.repository.OrderRepository;

import java.util.List;

@Service

public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order) {return orderRepository.save(order);}
    public List<Order> getAllOrder(){ return orderRepository.findAll();}
    public Order getOrderByID(int id){return orderRepository.findById(id).get();}
    public Order UpdateOrder(Order order){return orderRepository.saveAndFlush(order);}
    public void deleteOrder(int id){ orderRepository.deleteById( id);}
}
