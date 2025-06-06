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
import rs.edu.cubes.doservice.model.Location;
import rs.edu.cubes.doservice.service.LocationService;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	
	private LocationService service;

	public LocationController(LocationService service) {
		this.service = service;
	}
	
	
	@GetMapping
	public String getLocationsPage(Model model) {
		
		model.addAttribute("locations", service.getAllLocations());
		
		
		return "locations";
	}
	
	@GetMapping("/add")
	public String getLocationssFormPage(Model model) {
		
		model.addAttribute("location", new Location());
		
		return "locations-form";
	}
	
	@GetMapping("/update/{id}")
	public String getLocationsUpdateFormPage(@PathVariable int id, Model model) {
		
		model.addAttribute("locations", service.getLocation(id));
		
		
		return "locations-form";
	}
	
	@PostMapping("/save")
	public String getLocationsSave(@Valid @ModelAttribute Location location ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "locations-form";
		}
		
		service.saveLocation(location);
	
		
		return "redirect:/locations";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteLocation(Location location) {
		
		service.deleteLocation(location);
		
		return "redirect:/locations";
	}
	
	
	
}
