package rs.edu.cubes.doservice.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import rs.edu.cubes.doservice.model.ServiceType;
import rs.edu.cubes.doservice.model.Task;
import rs.edu.cubes.doservice.model.TaskStatus;
import rs.edu.cubes.doservice.service.TaskService;
import rs.edu.cubes.doservice.service.TechnicianService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	
	private TaskService taskService;
	private TechnicianService technicianService;
	
	
	
	public TaskController(TaskService taskService, TechnicianService technicianService) {

		this.taskService = taskService;
		this.technicianService = technicianService;
	}



	@GetMapping
	public String getTasksPage(Model model, @RequestParam(value = "status", required = false) String status) {
		if (status == null)
			model.addAttribute("tasks", taskService.getAllTasks());
		else if (status.equalsIgnoreCase("COMPLETED"))
			model.addAttribute("tasks", taskService.getTasksByStatus(TaskStatus.COMPLETED));
		else if (status.equalsIgnoreCase("IN_PROGRESS"))
			model.addAttribute("tasks", taskService.getTasksByStatus(TaskStatus.IN_PROGRESS));
		else if (status.equalsIgnoreCase("PENDING"))
			model.addAttribute("tasks", taskService.getTasksByStatus(TaskStatus.PENDING));

		return "tasks";
	}
	
	
	@GetMapping("/add")
	public String getTasksFormPage(Model model) {
		
		model.addAttribute("task", new Task());
		model.addAttribute("technicians", technicianService.getAllTechnicians());
		model.addAttribute("serviceTypes", ServiceType.values());
		model.addAttribute("statuses", TaskStatus.values());
		
		return "tasks-form";
	}
	
	@GetMapping("/update/{id}")
	public String getTasksUpdateFormPage(@PathVariable int id, Model model) {
		
		model.addAttribute("task", taskService.getTask(id));
		model.addAttribute("technicians", technicianService.getAllTechnicians());
		model.addAttribute("serviceTypes", ServiceType.values());
		model.addAttribute("statuses", TaskStatus.values());
		
		return "tasks-form";
	}
	
	@PostMapping("/save")
	public String getTasksSave(@Valid @ModelAttribute Task task ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "tasks-form";
		}
		
		taskService.saveTask(task);
		
		return "redirect:/tasks";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteTask(@PathVariable int id) {
		
		taskService.deleteTask(id);
		
		return "redirect:/tasks";
	}

}
