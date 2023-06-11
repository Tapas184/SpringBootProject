package com.nt.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.Transient;

import lombok.Data;

@Entity
@Data
@Table(name = "emp")
//for soft deletion
@SQLDelete(sql = "UPDATE EMP SET STATUS='deleted' WHERE empno=?")
@Where(clause = "STATUS!='deleted'")
public  final class EmployeeModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2487452628718767436L;
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
