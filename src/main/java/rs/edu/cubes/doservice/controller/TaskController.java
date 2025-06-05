package rs.edu.cubes.doservice.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

import rs.edu.cubes.doservice.model.Task;
import rs.edu.cubes.doservice.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	
	private TaskService service;
	
	
	
	public TaskController(TaskService service) {
		this.service = service;
	}



	@GetMapping
	public String getTasksPage(Model model) {
		
		model.addAttribute("tasks", service.getAllTasks());
		
		
		return "tasks";
	}
	
	//KONTROLA
	
	@GetMapping("/add")
	public String getTasksFormPage(Model model) {
		
		model.addAttribute("task", new Task());
		
		return "tasks-form";
	}
	
	@GetMapping("/update/{id}")
	public String getTasksUpdateFormPage(@PathVariable int id, Model model) {
		
		model.addAttribute("task", service.getTask(id));
		
		
		return "tasks-form";
	}
	
	@PostMapping("/save")
	public String getTasksSave(@Valid @ModelAttribute Task task ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "tasks-form";
		}
		
		service.saveTask(task);
		
		return "redirect:/tasks";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteTask(Task task) {
		
		service.deleteTask(task);
		
		return "redirect:/tasks";
	}

}
