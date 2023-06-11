package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.init.RepositoriesPopulatedEvent;
import org.springframework.stereotype.Service;

import com.nt.model.EmployeeModel;
import com.nt.repository.IEmployeeRepository;

@Service("service")
//make the calls for auto configuration through @Service
public class EmolyeeServiceImp implements IEmployeeService {
	
	//insert Employee repository interface
	@Autowired
	//through field injection inject the dependency
	private IEmployeeRepository repo;

	@Override
	public Iterable<EmployeeModel> getAllEmployee() {
		//call persistence logic through repository
		return repo.findAll(Sort.by("ename").ascending());
	}

	@Override
	public String insertEmployee(EmployeeModel emp) {
		int id = repo.save(emp).getEmpno();
		return "Employee Details inserted with Emplyee ID :"+id;
	}
	@Override
	public EmployeeModel getEmployeeById(Integer id) {
		//call the repository predefined method
		return repo.getReferenceById(id); //it will give the referenced ID Employee Object
	}
	@Override
	public String updateEmpDetails(EmployeeModel emp) {
		return repo.save(emp).getEmpno()+" Id Employee details Updated";
	}
	@Override
	public String deleteEmployeeByID(Integer id) {
		  //call the repository method for delete the employee method
		Optional<EmployeeModel> opt = repo.findById(id);
		if(opt.isPresent()) {
			repo.deleteById(id);
			return  id+" - Id  Employee details deleted";
		}
			
		return id+" Is not availabe in data base";
	}

	@Override
	public Page<EmployeeModel> getEmployee(Pageable pageable) {
		return repo.findAll(pageable);
	}
}//end class of EmolyeeServiceImp
