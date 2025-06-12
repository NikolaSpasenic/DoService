package rs.edu.cubes.doservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import rs.edu.cubes.doservice.model.TaskStatus;
import rs.edu.cubes.doservice.service.TaskService;


@Controller
public class DashboardController {

	
	private TaskService taskService;
	
	

	public DashboardController(TaskService taskService) {
		this.taskService = taskService;
	}





	@GetMapping({"/","/index","/homepage","/dashboard"})
	public String getHomePage(Model model) {
		
		model.addAttribute("doneTasks", taskService.getTasksByStatus(TaskStatus.COMPLETED).size());
		model.addAttribute("inProgressTasks", taskService.getTasksByStatus(TaskStatus.IN_PROGRESS).size());
		model.addAttribute("waitingTasks", taskService.getTasksByStatus(TaskStatus.PENDING).size());

		return "dashboard";
	}

	
}
