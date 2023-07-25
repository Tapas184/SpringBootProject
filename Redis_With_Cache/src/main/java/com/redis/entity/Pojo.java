package com.redis.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Pojo")
public class Pojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1549297718919099862L;
	private Integer id;
	private String name;
	
	
	public Pojo() {

	}
	public Pojo(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
}
