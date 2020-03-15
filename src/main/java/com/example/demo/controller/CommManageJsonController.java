package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Orders;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.service.CommManageService;

@RestController
public class CommManageJsonController {

	@Autowired
	private CommManageService cs;
	@RequestMapping("memberOrderJson")
	public List<Orders> memberOrder(int uid) {
		List<Orders> list=cs.getByUid(uid);
		return list;
	}
}
