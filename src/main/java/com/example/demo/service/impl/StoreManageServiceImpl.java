package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Sale;
import com.example.demo.entity.Store;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.mapper.ShopownerMapper;
import com.example.demo.mapper.StoreMapper;
import com.example.demo.service.CommManageService;
import com.example.demo.service.StoreManageService;


@Service
public class StoreManageServiceImpl implements StoreManageService{

	@Autowired
	private ShopownerMapper sm;
	
	@Autowired
	private StoreMapper smp;

	@Override
	public List<Sale> getBySid(int sid) {
		// TODO Auto-generated method stub
		return sm.getBySid(sid);
	}

	@Override
	public List<Store> getByArea(String area) {
		// TODO Auto-generated method stub
		return smp.getByArea(area);
	}

	@Override
	public List<Store> getByAll() {
		// TODO Auto-generated method stub
		return smp.getByAll();
	}

	@Override
	public List<Store> getByCity(String city) {
		// TODO Auto-generated method stub
		return smp.getByCity(city);
	}

	@Override
	public List<Store> getByStorename(String storename) {
		// TODO Auto-generated method stub
		return smp.getByStorename(storename);
	}

	@Override
	public int updateClickByid(int id, int click) {
		// TODO Auto-generated method stub
		return smp.updateClickByid(id, click);
	}

	@Override
	public List<Store> getByClick() {
		// TODO Auto-generated method stub
		return smp.getByClick();
	}

	@Override
	public List<Store> getByCityAndArea(String city, String area) {
		// TODO Auto-generated method stub
		return smp.getByCityAndArea(city, area);
	}
	

}
