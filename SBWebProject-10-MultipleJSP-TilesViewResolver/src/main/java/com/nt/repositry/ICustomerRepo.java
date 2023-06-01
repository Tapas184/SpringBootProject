package com.nt.repositry;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.model.Customer;

public interface ICustomerRepo extends PagingAndSortingRepository<Customer, Integer> {

}
