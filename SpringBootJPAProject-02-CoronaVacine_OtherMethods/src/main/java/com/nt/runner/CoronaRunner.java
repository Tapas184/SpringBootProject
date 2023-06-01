//Developing client code using spring boot runners
package com.nt.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVacine;
import com.nt.service.ICoronaVaccineMgmtService;
@Component
public class CoronaRunner implements CommandLineRunner {
	@Autowired
	private ICoronaVaccineMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		try {
			/*CoronaVacine vaccine = new CoronaVacine(null,"Covishild","India-BioTech","India",600.0,5);
			System.out.println(service.registerVaccine(vaccine));*/
			// Bulk insertion---> batch insertion
			/*Iterable<CoronaVacine> batchVaccine = service.batchProcessing(List.of(new CoronaVacine(null,"Sputnik","Russie","Rusia",578.0,10),
					                                                              new CoronaVacine(null,"Pyzer", "Pyzer", "USA",456.6,6),
					                                                              new CoronaVacine(null,"Moderena","Moderena","USA",560.6,5)
					));*/
			/*			Iterable<CoronaVacine> batchVaccine = service
								.batchProcessing(Arrays.asList(
										new CoronaVacine(null, "Sputnik", "Russie", "Rusia",
												578.0, 10),
										new CoronaVacine(null, "Pyzer", "Pyzer", "USA",
												456.6, 6),
										new CoronaVacine(null, "Moderena", "Moderena",
												"USA", 560.6, 5)));
						System.out.println("Registor Number count is::");
						batchVaccine
								.forEach(vacine -> System.out.println(vacine.getRegNo()));*/
			/*			System.out.println("Vaccine Count is :: "+service.getCount());
						System.out.println("Vaccine availablity ::"+service.checkAval(103));*/
			/*			System.out.println("===============For retrive All data================");
						Iterable<CoronaVacine> listIter =service.fatchAllDetails();
						listIter.forEach(vac->{
							System.out.println(vac);
						});
						System.out.println("--------Single line Lamda expresion-------");
						listIter.forEach(vax->System.out.println(vax));
						System.out.println("=========Method Reference============");
						service.fatchAllDetails().forEach(System.out::println);
						System.out.println("===============By Stream IO ================");
						Arrays.asList(service.fatchAllDetails()).stream().forEach(System.out::println);
						System.out.println("===============Map=================");
						Arrays.asList(service.fatchAllDetails()).stream().map(s->s).forEach(System.out::print);*/
			/*		Iterable<CoronaVacine> listIter =service.fatchAllDetailsByIds(List.of(12L,21L,103L,104L));
					listIter.forEach(vac->{
						System.out.println(vac);
					});
					System.out.println("--------Single line Lamda expresion-------");
					service.fatchAllDetailsByIds(List.of(12L,21L,103L,104L)).forEach(vax->System.out.println(vax));
					System.out.println("=========Method Reference============");
					service.fatchAllDetailsByIds(List.of(12L,21L,103L,104L)).forEach(System.out::println);
					System.out.println("===============By Stream IO ================");
					Arrays.asList(service.fatchAllDetailsByIds(List.of(12L,21L,103L,104L))).stream().forEach(System.out::println);
					System.out.println("===============Map=================");
					Arrays.asList(service.fatchAllDetailsByIds(List.of(12L,21L,103L,104L))).stream().map(s->s).forEach(System.out::print);*/
			/*			System.out.println("=========Using Optional Method=================");
						Optional<CoronaVacine> opt = service.fatchAllDetailsById(12L);
						if(opt.isPresent())
							System.out.println(opt.get());
						else
							System.out.println("Vaccine not available");
						System.out.println("=========Another Method==========");
						if(opt.isPresent())
							System.out.println(opt);
						//opt.orElseThrow(()->new IllegalArgumentException("Vaccine not Found"));
						System.out.println(opt.orElse(new CoronaVacine()));*/
			System.out.println("============Delete Operation==============");
			System.out.println(service.deleteAllById(1L));
			
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} // catch
	}

}
