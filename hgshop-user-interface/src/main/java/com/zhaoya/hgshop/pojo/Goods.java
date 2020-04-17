package com.zhaoya.hgshop.pojo;

import java.io.Serializable;

public class Goods implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String price;
	private String level;
	private String sum;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Goods(Integer id, String name, String price, String level, String sum) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.level = level;
		this.sum = sum;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
   
	
}
