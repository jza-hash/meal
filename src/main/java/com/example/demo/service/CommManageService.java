package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Comm;
import com.example.demo.entity.Orders;

public interface CommManageService {
    
	List<Orders> getByUid(int uid);

	Comm Login(String phone,String password);
}
