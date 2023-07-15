package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.DemoEntity;

public interface DemoRepo extends JpaRepository<DemoEntity, Integer> {

}
