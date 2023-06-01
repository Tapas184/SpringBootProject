package com.nt.model.offers;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "MDS_OFFERS")
@RequiredArgsConstructor
@NoArgsConstructor
public class Offers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 20)
	@NonNull
	private String offername;
	@Column(length = 20)
	@NonNull
	private String code;
	@NonNull
	private LocalDateTime exparydate;

}
