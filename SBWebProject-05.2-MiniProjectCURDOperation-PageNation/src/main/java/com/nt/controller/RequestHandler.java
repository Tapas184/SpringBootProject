package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.EmployeeModel;
import com.nt.service.IEmployeeService;
import com.nt.validator.EmployeeFormValidator;

import jakarta.servlet.http.HttpSession;

@Controller
//request handler class for all request(get/post)
public class RequestHandler {

	@Autowired
	// inject the service class object by Interface so we can maintain abstraction
	private IEmployeeService service;
	@Autowired
	// inject the validator class
	private EmployeeFormValidator validator;

	@GetMapping("/")
	// showHome method for showing home page request
	public String showHome() {
		// return logical view name
		return "home";
	}

	/*	@GetMapping("/report")
		// method for request show employee details
		public String showEmployeeList(Map<String, Object> map) {
			// call the b-logic and get the Iterable object
			Iterable<EmployeeModel> result = service.getAllEmployee();
			// add the emplist to Map object
			map.put("emplist", result);
			// return logical view name
			return "emp_report";
		}*/

	@GetMapping("/report")
	// method for request show employee details
	public String showEmployeeList(Map<String, Object> map,
			@PageableDefault(page = 0, size = 3, sort = "job", direction = Direction.ASC) Pageable pageable) {
		// call the b-logic and get the Iterable object
		// gather data by page by page
		Page<EmployeeModel> page = service.getEmployee(pageable);
		// add the emplist to Map object
		map.put("pagedata", page);
		// return logical view name
		return "emp_report";
	}

	/*
	 * create request trap handler methods for add employee request ModelAttribute
	 * taken for reson while we inserting dat in form table it show map with Model
	 * class
	 */
	@GetMapping("/add")
	public String addEmployeeRequest(@ModelAttribute("emp") EmployeeModel emp) {
		// create a logical view for add Employee request
		return "emp_add";
	}

	/*
	 * @PostMapping("/add") public String inserTingEmployee(RedirectAttributes rda,
	 * 
	 * @ModelAttribute("emp") EmployeeModel emp) { //Invoke the b-logic String
	 * result = service.insertEmployee(emp); rda.addFlashAttribute("resultMsg",
	 * result); //redirect for PostRedirect problem return "redirect:report"; }
	 */
	@PostMapping("/add")
	public String inserTingEmployee(HttpSession ses, @ModelAttribute("emp") EmployeeModel emp, BindingResult errors) { // BindingResult
																														// errors
																														// instead
																														// of
																														// you
																														// can
																														// take
																														// BindingException
		// for Application about some logic(Application validation)
		if (emp.getJob().equalsIgnoreCase("KING") || emp.getJob().equalsIgnoreCase("QUEEN")
				|| emp.getJob().equalsIgnoreCase("president")) {
			errors.rejectValue("job", "emp.job.business-restriction");
			return "emp_add";
		}
		// before the calling business method we have to validate form
		// for check whether client site verification is done or not
		if (emp.getHflag().equalsIgnoreCase("no"))
			if (validator.supports(emp.getClass())) { // this will check the correct class or not
				validator.validate(emp, errors); // this will check whether error is available or not
				if (errors.hasErrors()) // if error is available
					return "emp_add"; // return add employee form page url
			}
		// Invoke the b-logic
		String result = service.insertEmployee(emp);
		// if you want to show message
		ses.setAttribute("resultMsg", result);
		ses.setMaxInactiveInterval(5);
		// redirect for PostRedirect problem
		return "redirect:report";
	}

	@GetMapping("/edit")
	// method for edit request handler
	public String showEdidForm(@RequestParam("empno") Integer no, @ModelAttribute("emp") EmployeeModel emp) {
		// Invoke the service method
		EmployeeModel emp1 = service.getEmployeeById(no);
		// copy the emp1 bean data to Model attribute emp bean data
		BeanUtils.copyProperties(emp1, emp);
		return "edit_emp";
	}

	@PostMapping("/edit")
	public String updateEmpEdiRequest(HttpSession ses, @ModelAttribute("emp") EmployeeModel emp, BindingResult errors) {
		// before the calling business method we have to validate form
		// for Application about some logic(Application validation)
		if (emp.getJob().equalsIgnoreCase("KING") || emp.getJob().equalsIgnoreCase("QUEEN")
				|| emp.getJob().equalsIgnoreCase("president")) {
			errors.rejectValue("job", "emp.job.business-restriction");
			return "edit_emp";
		}
		// for check whether client site verification is done or not
		if (emp.getHflag().equalsIgnoreCase("no"))
			if (validator.supports(emp.getClass())) { // this will check the correct class or not
				validator.validate(emp, errors); // this will check whether error is available or not
				if (errors.hasErrors()) // if error is available
					return "edit_emp"; // return add employee form page url
			}
		// Invoke the business method
		String result = service.updateEmpDetails(emp);
		// add the result message in session
		ses.setAttribute("resultMsg", result);
		// set the message visible time
		ses.setMaxInactiveInterval(7);
		// redirect the request to report for avoiding double posting problem
		return "redirect:report";
	}

	/*	@GetMapping("/delete")
		public String deleteRequest(Map<String, Object> map, @RequestParam("empno") Integer no) {
			// Invoke b-method String result =
			String result = service.deleteEmployeeByID(no);
			// get Iterable Employee object
			Iterable<EmployeeModel> emp1 = service.getAllEmployee();
			// put the resultmessage into Map object
			map.put("resultMsg", result);
			map.put("emplist", emp1);
			// return Logical view name
			return "emp_report";
		}*/

	@GetMapping("/delete")
	public String deleteRequest(HttpSession ses, @RequestParam("empno") Integer no) {
		// Invoke b-method
		String result = service.deleteEmployeeByID(no);
		ses.setAttribute("resultMsg", result);
		ses.setMaxInactiveInterval(7);
		// redirect the padge to report
		return "redirect:report";
	}

}// end of class RequestHandler
