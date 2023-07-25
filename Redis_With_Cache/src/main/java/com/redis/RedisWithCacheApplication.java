package com.redis;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.Pojo;
import com.redis.entity.Product;
import com.redis.repository.ProductDAO;

@SpringBootApplication
@RestController
@RequestMapping("/product")
@EnableCaching
public class RedisWithCacheApplication {
	
	@Autowired
	private ProductDAO repo;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@GetMapping
	public List<Object> getAllProduct(){
		return repo.findAll();
	}
	
	@DeleteMapping("/{id}")
	@CacheEvict                      //This is used for delete the record from DB as well from cache.
	                               //@CachePut( this is used for update in data base as well to save in cache)
	public String remove(@PathVariable int id) {
		return repo.deleteProduct(id);
	}

	@GetMapping("/{id}")
	@Cacheable(key = "#id",value = "Product") // we can use Unless for any condition if we want to pass
	public Product getById(@PathVariable int  id) {
		return repo.findById(id);
	}
	
	@GetMapping("/pojo/{id}")
	@Cacheable(value = "Pojo",key = "#id")
	public Pojo getPojo(@PathVariable int id) {
		Product prod = repo.findById(id);
		Pojo pojo = new Pojo();
		BeanUtils.copyProperties(prod, pojo);
		return pojo;
	}
	public static void main(String[] args) {
		SpringApplication.run(RedisWithCacheApplication.class, args);
	}

}
