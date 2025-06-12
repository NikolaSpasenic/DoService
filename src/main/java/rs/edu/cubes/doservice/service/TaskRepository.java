package rs.edu.cubes.doservice.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.edu.cubes.doservice.model.Task;
import rs.edu.cubes.doservice.model.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

    List<Task> getTasksByStatus(TaskStatus status);
}
