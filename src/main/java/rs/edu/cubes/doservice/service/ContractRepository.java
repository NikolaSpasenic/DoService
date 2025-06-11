package rs.edu.cubes.doservice.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.edu.cubes.doservice.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer>{
	
	
	List<Contract> findByEmployeeId(int id);
		
	

}
