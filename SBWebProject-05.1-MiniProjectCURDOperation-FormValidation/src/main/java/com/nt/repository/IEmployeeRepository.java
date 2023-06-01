package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.EmployeeModel;

public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Integer> {

}
