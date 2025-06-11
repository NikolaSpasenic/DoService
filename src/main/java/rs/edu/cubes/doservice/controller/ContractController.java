package rs.edu.cubes.doservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import rs.edu.cubes.doservice.model.Contract;
import rs.edu.cubes.doservice.model.Employee;
import rs.edu.cubes.doservice.service.ContractService;
import rs.edu.cubes.doservice.service.EmployeeService;
import rs.edu.cubes.doservice.service.PositionService;

@Controller
@RequestMapping("/contracts")
public class ContractController {
	
	private ContractService service;
	private PositionService positionService;
	private EmployeeService employeeService;

	
	
	
	

	public ContractController(ContractService service, PositionService positionService,
			EmployeeService employeeService) {
		super();
		this.service = service;
		this.positionService = positionService;
		this.employeeService = employeeService;
	}


	@GetMapping("/{employeeId}")
	public String getContractsPage(@PathVariable int employeeId ,Model model) {
		
		model.addAttribute("contracts", service.getEmployeesContract(employeeId));
		model.addAttribute("employeeId", employeeId);
		
		return "contracts";
	}
	
	
	@GetMapping("/{employeeId}/add")
	public String getContractsFormPage(@PathVariable int employeeId, Model model) {
		
		Contract contract = new Contract();
		Employee employee = employeeService.getEmployee(employeeId);
		contract.setEmployee(employee);
		
		model.addAttribute("contract", contract);
		model.addAttribute("positions", positionService.getAllPositions());
		model.addAttribute("employeeId", employeeId );

		
		return "contracts-form";
	}
	
	
	@GetMapping("/{employeeId}/update/{id}")
	public String getContractsUpdateFormPage(@PathVariable int employeeId, @PathVariable int id, Model model) {
		
		model.addAttribute("contract", service.getContract(id));
		model.addAttribute("positions", positionService.getAllPositions());
		model.addAttribute("employeeId", employeeId );
		
		return "contracts-form";
	}
	
	@PostMapping("/{employeeId}/save")
	public String getContractsSave(@PathVariable int employeeId, @Valid @ModelAttribute Contract contract,BindingResult result) {
		
		Employee employee = employeeService.getEmployee(employeeId);
		contract.setEmployee(employee);
		
		if(result.hasErrors()) {
			return "contracts-form";
		}
		
		service.saveContract(contract);
		
		return "redirect:/contracts";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteContract(@PathVariable int id) {
		
		service.deleteContract(id);
		
		return "redirect:/contracts";
	}
	
	
	

}
