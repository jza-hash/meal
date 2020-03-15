package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Sale;
import com.example.demo.entity.Store;

public interface StoreManageService {
    
    List<Sale> getBySid(int sid);        //查询某一餐厅 当年每月份的销售量
    
    List<Store> getByAll();              //创建索引

    List<Store> getByArea(String area);               //搜索引擎功能 待改进
    
    List<Store> getByCity(String city);               //搜索引擎功能 待改进

    List<Store> getByStorename(String storename);               //搜索引擎功能 待改进
    
    int updateClickByid(int id,int click);                      //根据搜索次数 更新 点击量
    
    List<Store> getByClick();                          //更具点击量 列出热搜索的餐厅 
    
    List<Store> getByCityAndArea(String city,String area);   //防止用户输入 空格及市区值同步输入
}
