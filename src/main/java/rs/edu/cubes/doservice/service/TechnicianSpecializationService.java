package rs.edu.cubes.doservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.edu.cubes.doservice.model.TechnicianSpecialization;

@Service
public class TechnicianSpecializationService {
	
	private TechnicianSpecializationRepository repository;

	public TechnicianSpecializationService(TechnicianSpecializationRepository repository) {
		this.repository = repository;
	}
	
	
	public List<TechnicianSpecialization> getAllTechnicianSpecializations() {
		return repository.findAll();
	}
	
	public TechnicianSpecialization saveTechnicianSpecialization(TechnicianSpecialization technicianSpecialization) {
		return repository.save(technicianSpecialization);
	}
	
	public TechnicianSpecialization getTechnicianSpecialization(int id) {
		return repository.getById(id);
	}
	
	public void  deleteTechnicianSpecialization(TechnicianSpecialization technicianSpecialization) {
		repository.delete(technicianSpecialization);
	}
	
	
	

}
