package com.nt.repositry;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.model.Employee;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

}
