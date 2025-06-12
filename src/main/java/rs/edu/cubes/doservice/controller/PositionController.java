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
import rs.edu.cubes.doservice.model.Position;
import rs.edu.cubes.doservice.service.PositionService;

@Controller
@RequestMapping("/positions")
public class PositionController {
	
	
	private PositionService service;

	public PositionController(PositionService service) {
		this.service = service;
	}
	
	
	@GetMapping
	public String getPositionsPage(Model model) {
		
		model.addAttribute("positions", service.getAllPositions());
		
		
		return "postions";
	}
	
	
	@GetMapping("/add")
	public String getPositionsFormPage(Model model) {
		
		
		
		model.addAttribute("position", service.getAllPositions());
		
		
		return "positions-form";
	}
	
	
	@GetMapping("/update/{id}")
	public String getPositionssUpdateFormPage(@PathVariable int id, Model model) {
		
		model.addAttribute("position", service.getPosition(id));
		
		
		return "positions-form";
	}
	
	@PostMapping("/save")
	public String getPositionsSave(@Valid @ModelAttribute Position position ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "positions-form";
		}
		
		service.savePosition(position);
		
		return "redirect:/positions";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeletePosition(@PathVariable int id) {
		
		service.deletePosition(id);
		
		return "redirect:/positions";
	}
	
	
	

}
