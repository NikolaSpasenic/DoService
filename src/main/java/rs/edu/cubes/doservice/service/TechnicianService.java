package rs.edu.cubes.doservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.edu.cubes.doservice.model.Technician;

@Service
public class TechnicianService {
	
	
	private TechnicianRepository repository;

	public TechnicianService(TechnicianRepository repository) {
		this.repository = repository;
	}
	
	
	
	public List<Technician> getAllTechnicians() {
		return repository.findAll();
	}
	
	public Technician saveTechnician(Technician technician) {
		return repository.save(technician);
	}
	
	public Technician getTechnician(int id) {
		return repository.getById(id);
	}
	
	public void deleteTechnician(int technicianId) {
		repository.deleteById(technicianId);
	}
	
	

}
