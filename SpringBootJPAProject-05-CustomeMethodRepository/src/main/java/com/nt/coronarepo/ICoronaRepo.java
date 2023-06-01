
//This is the marker Interface
package com.nt.coronarepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVacine;

public interface ICoronaRepo extends JpaRepository<CoronaVacine, Long> {
	//It use Internally SELECT QUERY WITH COLUMN Names
	public List<CoronaVacine> findByCompany(String company);
}
