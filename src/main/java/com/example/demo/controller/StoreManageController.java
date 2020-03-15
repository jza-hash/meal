package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Orders;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.service.CommManageService;
import com.example.demo.service.StoreManageService;

@Controller
public class StoreManageController {

	@Autowired
	private StoreManageService sm;
	@RequestMapping("StoreChart")
	public ModelAndView memberOrder(String logintoken) {
		ModelAndView md=new ModelAndView();
		md.addObject("logintoken",logintoken);
		md.setViewName("member_chart");
		return md;
	}
	
}
