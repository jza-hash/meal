package com.example.demo.mapper;

import com.example.demo.entity.Permission;
import com.example.demo.entity.PermissionExample;
import java.util.List;

public interface PermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int insert(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int insertSelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    List<Permission> selectByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    Permission selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int updateByPrimaryKey(Permission record);
}