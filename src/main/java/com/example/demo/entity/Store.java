package com.example.demo.entity;

public class Store {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.id
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.storename
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    private String storename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.name
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.city
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    private String city;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.area
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    private String area;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.phone
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    private Integer phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.picture
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    private String picture;
    
    private int click;

    public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.id
     *
     * @return the value of store.id
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.id
     *
     * @param id the value for store.id
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.storename
     *
     * @return the value of store.storename
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public String getStorename() {
        return storename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.storename
     *
     * @param storename the value for store.storename
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.name
     *
     * @return the value of store.name
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.name
     *
     * @param name the value for store.name
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.city
     *
     * @return the value of store.city
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.city
     *
     * @param city the value for store.city
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.area
     *
     * @return the value of store.area
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.area
     *
     * @param area the value for store.area
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.phone
     *
     * @return the value of store.phone
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.phone
     *
     * @param phone the value for store.phone
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.picture
     *
     * @return the value of store.picture
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.picture
     *
     * @param picture the value for store.picture
     *
     * @mbg.generated Sun Aug 25 09:40:05 CST 2019
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
}