package com.nt.model;

import java.io.Serializable;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.Transient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "emp")
//for soft deletion
@SQLDelete(sql = "UPDATE EMP SET STATUS='deleted' WHERE empno=?")
@Where(clause = "STATUS!='deleted'")
public  final class EmployeeModel implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private String status="active";
	@Transient
	private String hflag="no";
	
	
	

}//end class EmployeeModel
