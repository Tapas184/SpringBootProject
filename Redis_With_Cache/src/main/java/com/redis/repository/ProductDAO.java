package com.redis.repository;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.entity.Product;

@Repository
public class ProductDAO {
	
	private static final Object HASH_KEY = "Product";
	
	Logger log = Logger.getLogger(ProductDAO.class.getName());

	
	@Autowired
	private RedisTemplate<Object,Object> template;
	
	public Product save(Product prod) {
		log.info("Hit the data base");
		template.opsForHash().put(HASH_KEY, prod.getId(), prod);
		return prod;
	}
	
	public List<Object> findAll(){
		log.info("Hit the data base");
		return template.opsForHash().values(HASH_KEY);
	}
	
	public Product findById(int id) {
		log.info("Hit the data base");
		return (Product) template.opsForHash().get(HASH_KEY, id);
	}
	
	public String deleteProduct(int id) {
		log.info("Hit the data base");
		template.opsForHash().delete(HASH_KEY, id);
		return "Product deleted";
	}

}
