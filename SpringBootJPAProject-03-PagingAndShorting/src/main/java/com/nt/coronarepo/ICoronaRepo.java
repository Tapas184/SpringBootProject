
//This is the marker Interface
package com.nt.coronarepo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.CoronaVacine;

public interface ICoronaRepo extends PagingAndSortingRepository<CoronaVacine, Long> {

}
