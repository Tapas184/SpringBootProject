
//This is the marker Interface
package com.nt.coronarepo;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.CoronaVacine;

public interface ICoronaRepo extends CrudRepository<CoronaVacine, Long> {

}
