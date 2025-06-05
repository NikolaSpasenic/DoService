package rs.edu.cubes.doservice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import rs.edu.cubes.doservice.model.ServiceType;
import rs.edu.cubes.doservice.model.Task;
import rs.edu.cubes.doservice.model.TaskStatus;
import rs.edu.cubes.doservice.model.Technician;
import rs.edu.cubes.doservice.model.TechnicianSpecialization;
import rs.edu.cubes.doservice.service.TechnicianService;

@Controller
@RequestMapping("/technicians")
public class TechnicianController {
	
	
	private TechnicianService techinicanService;

	public TechnicianController(TechnicianService techinicanService) {
		this.techinicanService = techinicanService;
	}
	
	
	@GetMapping
	public String getTechniciansPage(Model model) {
		
		model.addAttribute("technicians", techinicanService.getAllTechnicians());
		
		
		return "technicians";
	}
	
	
	@GetMapping("/add")
	public String getTechniciansFormPage(Model model) {
		
		//PROMENI
		TechnicianSpecialization specialization = new TechnicianSpecialization(1, "specijalizacija", LocalDateTime.now(), LocalDateTime.now());
		
		model.addAttribute("technician", new Technician());
		model.addAttribute("statuses", List.of("Active", "Inactive"));
		model.addAttribute("specializations", List.of(specialization));
		
		return "technicians-form";
	}
	
	
	@GetMapping("/update/{id}")
	public String getTechniciansUpdateFormPage(@PathVariable int id, Model model) {
		
		model.addAttribute("technician", techinicanService.getTechnician(id));
		
		
		return "technicians-form";
	}
	
	@PostMapping("/save")
	public String getTechniciansSave(@Valid @ModelAttribute Technician technician ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "technicians-form";
		}
		
		techinicanService.saveTechnician(technician);
		
		return "redirect:/technicians";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteTechnician(Technician technician) {
		
		techinicanService.deleteTechnician(technician);
		
		return "redirect:/technicians";
	}

}
