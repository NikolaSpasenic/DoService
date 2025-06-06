package rs.edu.cubes.doservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.edu.cubes.doservice.model.Location;

@Service
public class LocationService {
	
	private LocationRepository repository;

	public LocationService(LocationRepository repository) {
		this.repository = repository;
	}
	
	
	public List<Location> getAllLocations() {
		return repository.findAll();
	}
	
	public Location saveLocation(Location location) {
		if (location.getCreatedAt() == null)
			location.setCreatedAt(LocalDateTime.now());

		location.setUpdatedAt(LocalDateTime.now());

		return repository.save(location);
	}
	
	public Location getLocation(int id) {
		return repository.getById(id);
	}
	
	public void deleteLocation(int locationId) {
		repository.deleteById(locationId);
	}
	
	

}
