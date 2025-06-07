package rs.edu.cubes.doservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.edu.cubes.doservice.model.Task;


@Service
public class TaskService {
	
	
	private TaskRepository repository;

	
	public TaskService(TaskRepository repository) {
		this.repository = repository;
	}
	
	public List<Task> getAllTasks() {
		return repository.findAll();
	}
	
	
	public Task saveTask(Task task) {
		if (task.getCreatedAt() == null)
			task.setCreatedAt(LocalDateTime.now());

		task.setUpdatedAt(LocalDateTime.now());

		return repository.save(task);
	}
	
	public Task getTask(int id) {
		return repository.getById(id);
	}
	
	public void deleteTask(int taskId) {
		repository.deleteById(taskId);
	}
	
	
	
	

}
