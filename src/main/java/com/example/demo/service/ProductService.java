package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

	List<Product>  getProductByPid(int pid);   //根据商店查询商品

}
