package com.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.entity.Product;

@Repository
public class ProductDAO {
	
	private static final Object HASH_KEY = "Product";
	
	@Autowired
	private RedisTemplate<Object,?> template;
	
	public Product save(Product prod) {
		
		template.opsForHash().put(HASH_KEY, prod.getId(), prod);
		return prod;
	}
	
	public List<Object> findAll(){
		System.out.println("Hit the DB");
		return template.opsForHash().values(HASH_KEY);
	}
	
	public Product findById(int id) {
		System.out.println("Hit the DB");
		return (Product) template.opsForHash().get(HASH_KEY, id);
	}
	
	public String deleteProduct(int id) {
		System.out.println("HIT the data base");
		template.opsForHash().delete(HASH_KEY, id);
		return "Product deleted";
	}

}
