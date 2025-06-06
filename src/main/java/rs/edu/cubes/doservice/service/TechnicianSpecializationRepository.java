package rs.edu.cubes.doservice.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.edu.cubes.doservice.model.TechnicianSpecialization;

@Repository
public interface TechnicianSpecializationRepository extends JpaRepository<TechnicianSpecialization, Integer>{

}
