package com.nt.repogitory;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.CustomerModel;

public interface ICustomerRepo extends CrudRepository<CustomerModel, Integer> {

	public Optional<CustomerModel>  findByName(String name);
}
