package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "TOURIST_TABLE") //table name
@AllArgsConstructor  //All argument
@NoArgsConstructor //no argument
@RequiredArgsConstructor //required argument which is not Non_null
public class Tourist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;
	@NonNull
	@Column(length = 20)
	private String name;
	@NonNull
	@Column(length = 25)
	private String city;
	@NonNull
	@Column(length = 30)
	private String pakage;
	@NonNull
	private Double price;

}//end of the clazz Tourist
