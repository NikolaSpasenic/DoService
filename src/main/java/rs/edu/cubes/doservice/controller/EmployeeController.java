package rs.edu.cubes.doservice.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import rs.edu.cubes.doservice.model.Employee;

import rs.edu.cubes.doservice.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	
	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public String getEmployeesPage(Model model) {
		
		model.addAttribute("employees", service.getAllEmployees());
		
		
		return "employees";
	}
	
	
	@GetMapping("/add")
	public String getEmployeesFormPage(Model model) {
		
		
		
		model.addAttribute("employee", new Employee());
		
		
		return "employees-form";
	}
	
	
	@GetMapping("/update/{id}")
	public String getEmployeesUpdateFormPage(@PathVariable int id, Model model) {
		
		model.addAttribute("employee", service.getEmployee(id));
		
		
		return "employees-form";
	}
	
	@PostMapping("/save")
	public String getEmployeesSave(@Valid @ModelAttribute Employee employee ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "employees-form";
		}
		
		service.saveEmployee(employee);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteEmployee(@PathVariable int id) {
		
		service.deleteEmployee(id);
		
		return "redirect:/employees";
	}
	
	
	
	

}
