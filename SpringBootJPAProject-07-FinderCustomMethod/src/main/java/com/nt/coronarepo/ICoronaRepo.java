
//This is the marker Interface
package com.nt.coronarepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVacine;
import com.nt.type.CustomeView;

public interface ICoronaRepo extends JpaRepository<CoronaVacine, Long> {
	// SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT WHERE PRICE=?
	public List<CoronaVacine> findByPrice(double price);

	// SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT WHERE COUNTRY
	// IN(?,?,?) AND COMPANY IN(?,?,?)
	// AND PRICE BETWEEN ? AND ?
	public List<CoronaVacine> findByCountryIn(List<String> country);

	// custome view
	public List<CustomeView> findByPriceGreaterThanEqual(double price);

}
