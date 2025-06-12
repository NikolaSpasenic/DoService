package rs.edu.cubes.doservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.edu.cubes.doservice.model.Position;

@Service
public class PositionService {
	
	private PositionRepository repository;

	public PositionService(PositionRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	public List<Position> getAllPositions() {
		return repository.findAll();
	}
	
	public Position savePosition(Position position) {
		if (position.getCreatedAt() == null)
			position.setCreatedAt(LocalDateTime.now());

		position.setUpdatedAt(LocalDateTime.now());

		return repository.save(position);
	}
	
	public Position getPosition(int id) {
		return repository.getById(id);
	}
	
	public void deletePosition(int positionId) {
		repository.deleteById(positionId);
	}

}
