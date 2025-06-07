package rs.edu.cubes.doservice.service;

import java.time.LocalDateTime;
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
		if (technicianSpecialization.getCreatedAt() == null)
			technicianSpecialization.setCreatedAt(LocalDateTime.now());

		technicianSpecialization.setUpdatedAt(LocalDateTime.now());

		return repository.save(technicianSpecialization);
	}
	
	public TechnicianSpecialization getTechnicianSpecialization(int id) {
		return repository.getById(id);
	}
	
	public void  deleteTechnicianSpecialization(int specializationId) {
		repository.deleteById(specializationId);
	}
	
	
	

}
