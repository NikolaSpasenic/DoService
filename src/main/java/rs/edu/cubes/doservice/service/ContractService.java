package rs.edu.cubes.doservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.edu.cubes.doservice.model.Contract;

@Service
public class ContractService {
	
	private ContractRepository repository;

	public ContractService(ContractRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<Contract> getAllContracts() {
		return repository.findAll();
	}
	
	public Contract saveContract(Contract contract) {
		return repository.save(contract);
	}
	
	public Contract getContract(int id) {
		return repository.getById(id);
	}
	
	public void deleteContract(int contractId) {
		repository.deleteById(contractId);
	}
	
	public List<Contract> getEmployeesContract(int id) {
		return repository.findByEmployeeId(id);
	}
}
