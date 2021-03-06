package com.example.demo.mapper;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductExample;
import java.util.List;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    List<Product> selectByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int updateByPrimaryKey(Product record);
    
    List<Product>  getProductByPid(int pid);   //根据商店查询商品
}