package com.nt.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CUST_INFO")
public class CustomerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	@Column(length = 20,unique = true,nullable = false)
	private String name;
	@Column(length = 60, nullable = false)
	private String pwd;
	@Column(length = 30)
	private String email;
	private Boolean status=true;
	@ElementCollection(fetch =FetchType.EAGER)
	@CollectionTable(name = "CUST_ROLE", joinColumns = @JoinColumn(name="cust_id", referencedColumnName = "cid"))
	@Column(name = "role")
	private Set<String> roles;

}
