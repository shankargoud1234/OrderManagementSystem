package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAllOrderdetails() {
		return orderRepository.findAll();
	}

	@PostMapping("/createUser")
	public Order creatOrders(Order order) {
		return orderRepository.save(order);
	}

}
