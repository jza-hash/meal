package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductControllerJson {

	@Autowired
	private ProductService ps;
	@RequestMapping("productJson")
	public List<Product> get(int pid) {
		List<Product> list=ps.getProductByPid(pid);
		return list;
	}

	@RequestMapping("productJson1")
	public List<Product> getByMoney(int pid) {
		List<Product> list=ps.getProductByPid(pid);
		return list;
	}
	
}
