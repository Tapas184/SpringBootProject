package com.redis.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3544562729034421400L;
	private Integer id;
	private String name;
	private Integer qty;
	private Long price;
	
	
	
	public Product(Integer id, String name, Integer qty, Long price) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
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
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}
	
	
}
