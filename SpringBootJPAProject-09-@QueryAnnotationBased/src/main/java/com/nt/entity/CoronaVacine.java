package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
//@Table(name ="CORONA_VACINE_TAB"){If you want to table name as per class name}
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CoronaVacine implements Serializable {
	@Id
	// @Column(name ="SR_NO"){If we want parameter name same as column name}
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regNo;
	@NonNull
	@Column(length = 20) // {set string column character length}
	private String name;
	@NonNull
	@Column(length = 30)
	private String company;
	@NonNull
	@Column(length = 20)
	private String country;
	@NonNull
	private Double price;
	@NonNull
	private Integer requiredDoseCount;
	public CoronaVacine(String company) {
		this.company = company;
	}
	
	

}// class
