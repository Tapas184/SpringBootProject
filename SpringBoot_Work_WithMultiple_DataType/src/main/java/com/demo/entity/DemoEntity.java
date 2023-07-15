package com.demo.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.conveter.ListConveter;
import com.demo.conveter.MapConverter;
import com.demo.conveter.SetConveter;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "DEMO_TABLE")
public class DemoEntity {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
    @Column(name = "Hobby")
    @Convert(converter = ListConveter.class)
	private List<String> hobbies;
	
    @Column(name = "Num")
    @Convert(converter = SetConveter.class)
	private Set<Integer> number;
	
	private String[] education;
	
    @Column(name = "Doc")
    @Convert(converter = MapConverter.class)
	private Map<String, String> document;
	
	public DemoEntity() {
		this.hobbies=new ArrayList<>();
		this.number=new HashSet<>();
		this.education=new String[5];
		this.document=new HashMap<>();
	}
	
	
	
	

}
