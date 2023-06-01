package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor  //All argument
@NoArgsConstructor //no argument
@RequiredArgsConstructor //required argument which is not Non_null
public class Tourist {
	private Integer tid;
	@NonNull
	private String name;
	@NonNull
	private String city;
	@NonNull
	private String pakage;
	@NonNull
	private Double price;

}//end of the clazz Tourist
