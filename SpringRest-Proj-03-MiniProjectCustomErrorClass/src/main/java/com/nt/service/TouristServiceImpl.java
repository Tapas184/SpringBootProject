package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.customexception.TouristNotFoundException;
import com.nt.entity.Tourist;
import com.nt.repository.ITouristRepo;
@Service("service")
public class TouristServiceImpl implements ITouristService {

	@Autowired //Interface type object inject by @Autowired
	private ITouristRepo repo;
	
	@Override
	public String registerTourist(Tourist tourist) throws Exception {
		int tid=repo.save(tourist).getTid();
		return "Tourist registered with "+tid;
	}

	@Override
	public Tourist getById(Integer id) throws TouristNotFoundException {
		
		return repo.findById(id).orElseThrow(() -> new TouristNotFoundException(id+" Id Tourist Not found"));
		//return repo.findById(id).get();
	}

	@Override
	public List<Tourist> fetchAllTourist() throws Exception {
		List<Tourist> touristList= repo.findAll();//get the Tourist List in List
		touristList.sort((t,t1)->t.getTid().compareTo(t1.getTid())); //Sort the list of tourist ascending by Tourist ID
				return touristList;//return Tourist list
	}//end of fetchAllTourist
	
@Override
public String updateTourist(Tourist tourist) throws TouristNotFoundException {
	//call the finder method to check whether tourist is availabe ir not
	Optional<Tourist> opt = repo.findById(tourist.getTid());
	//check the availability of tourist
	if(opt.isPresent()) {
		//if true update the  tourist
		repo.save(tourist);
		//return updat emessage to caller
		return tourist.getTid()+" Tourist updated";
	}
	else {
		//if not present 
		throw new TouristNotFoundException(tourist.getTid()+" Not found");
	}
}
}
