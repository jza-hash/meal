package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Comm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Orders;
import com.example.demo.mapper.CommMapper;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.service.CommManageService;


@Service
public class CommManageServiceImpl implements CommManageService{

	@Autowired
	private CommMapper cm;
	@Override
	public List<Orders> getByUid(int uid) {
		// TODO Auto-generated method stub
		return cm.getByUid(uid);
	}

	@Override
	public Comm Login(String phone, String password) {
		return cm.Login(phone,password);
	}


}
