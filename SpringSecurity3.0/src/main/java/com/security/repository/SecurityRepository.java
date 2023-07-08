package com.security.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entity.SecurityEntity;

public interface SecurityRepository extends JpaRepository<SecurityEntity,Serializable> {

	public Optional<SecurityEntity> findByUserName(String username);

}
