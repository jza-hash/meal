package com.example.demo.controller;

import com.example.demo.entity.Comm;
import com.example.demo.service.CommManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CommManageController {

	@Autowired
	private CommManageService cs;
	@RequestMapping("getIndex")
	public ModelAndView getIndex(String logintoken) {
		ModelAndView md=new ModelAndView();
		md.addObject("logintoken",logintoken);
		md.setViewName("index");
		return md;
	}
	
	@RequestMapping("memberIndex")
	public ModelAndView memberIndex(String logintoken) {
		ModelAndView md=new ModelAndView();
		md.addObject("logintoken",logintoken);
		md.setViewName("member_index");
		return md;
	}
	
	@RequestMapping("login")
	public ModelAndView login(String phone,String password,String fz) {
		ModelAndView mv=new ModelAndView();
		if (phone!=null&&password!=null){
			Comm islogin=cs.Login(phone,password);
			if(islogin==null){
				fz="1";
			}
			String flag="用户名或密码错误！";
			if(islogin==null){
				if (fz=="1"){
					mv.addObject("flag",flag);
				}
				mv.setViewName("login");
			}else{
				mv.setViewName("index");
			}
		}
//		HttpServletRequest request = null;
//		//创建session对象
//		HttpSession session = request.getSession();
//		//把用户数据保存在session域对象中
//		session.setAttribute("logintoken", phone);
//		HttpSession session2 = request.getSession();
//		System.out.println(session.getAttribute("logintoken"));
		mv.addObject("logintoken",phone);
		return mv;
	}
	
	@RequestMapping("memberCollect")
	public ModelAndView memberCollect(String logintoken) {
		ModelAndView md=new ModelAndView();
		md.addObject("logintoken",logintoken);
		md.setViewName("member_collect");
		return md;
	}
	
	@RequestMapping("memberOrder")
	public ModelAndView memberOrder(String logintoken) {
		ModelAndView md=new ModelAndView();
		md.addObject("logintoken",logintoken);
		md.setViewName("member_order");
		return md;
	}
	
	@RequestMapping("memberAddr")
	public ModelAndView memberAddr(String logintoken) {
		ModelAndView md=new ModelAndView();
		md.addObject("logintoken",logintoken);
		md.setViewName("member_addr");
		return md;
	}
	
	@RequestMapping("ProductList")
	public String productList() {
		return "shop_detail";
	}
	
	@RequestMapping("ShopList")
	public ModelAndView ShopList(String name) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("nam", name);
		mv.setViewName("shop_brand");
		return mv;
	}
}
