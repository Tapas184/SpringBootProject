
//This is the marker Interface
package com.nt.coronarepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVacine;

public interface ICoronaRepo extends JpaRepository<CoronaVacine, Long> {

}
