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
import rs.edu.cubes.doservice.model.TechnicianSpecialization;
import rs.edu.cubes.doservice.service.TechnicianSpecializationService;

@Controller
@RequestMapping("/specializations")
public class TechnicianSpecializationController {
	
	
	private TechnicianSpecializationService service;

	public TechnicianSpecializationController(TechnicianSpecializationService service) {
		this.service = service;
	}
	
	
	@GetMapping
	public String getTechnicianSpecializationsPage(Model model) {
		
		model.addAttribute("specializations", service.getAllTechnicianSpecializations());
		
		
		return "technician-specializations";
	}
	
	@GetMapping("/add")
	public String getTechniciansSpecializationsFormPage(Model model) {
		
		model.addAttribute("specialization", new TechnicianSpecialization());
		
		return "technician-specializations-form";
	}
	
	
	@GetMapping("/update/{id}")
	public String getTechnicianSpecializationsUpdateFormPage(@PathVariable int id, Model model) {
		
		model.addAttribute("specialization", service.getTechnicianSpecialization(id));
		
		
		return "technician-specializations-form";
	}
	
	@PostMapping("/save")
	public String getTechnicianSpecializationSave(@Valid @ModelAttribute TechnicianSpecialization technicianSpecialization ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "technician-specializations-form";
		}
		
		service.saveTechnicianSpecialization(technicianSpecialization);
		
		return "redirect:/specializations";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteTechnicianSpecialization(@PathVariable int id) {
		
		service.deleteTechnicianSpecialization(id);
		
		return "redirect:/specializations";
	}
	
	

}
