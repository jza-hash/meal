package com.example.demo.mapper;

import com.example.demo.entity.Role;
import com.example.demo.entity.RoleExample;
import java.util.List;

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    Role selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    int updateByPrimaryKey(Role record);
}