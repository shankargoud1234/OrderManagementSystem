package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/apiorders/")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Order>> getAllOrders() {
		return new ResponseEntity<List<Order>>(orderService.getAllOrderdetails(), HttpStatus.OK);
	}
	@PostMapping("/CreateOrders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.creatOrders(order), HttpStatus.CREATED);

	}

}
