package rs.edu.cubes.doservice.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.edu.cubes.doservice.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
