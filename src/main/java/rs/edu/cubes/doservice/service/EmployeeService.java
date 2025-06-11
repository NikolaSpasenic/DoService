package rs.edu.cubes.doservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.edu.cubes.doservice.model.Employee;

@Service
public class EmployeeService {
	
	
	private EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Employee getEmployee(int id) {
		return repository.getById(id);
	}
	
	public void deleteEmployee(int employeeId) {
		repository.deleteById(employeeId);
	}
	

}
