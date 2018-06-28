package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Occupation;
import com.example.demo.models.OccupationRepository;
;


@RestController
@RequestMapping("/occupation")
@CrossOrigin(origins = "http://localhost:4200")
public class OccupationController {
	
	@Autowired
	OccupationRepository occupationRepository;

	
	@GetMapping()
	public List<Occupation> getOccupation() {
		return occupationRepository.findAll();		
		
	}
	
	@PostMapping()
	public void createOccupation(@RequestBody Occupation occupation) {
		occupationRepository.save(occupation);
	
	}
	
	@DeleteMapping("/{id}")
	public void deleteOccupation(@PathVariable("id") int id) {
	Occupation occupationDelete = occupationRepository.findById(id).orElse(null);
		occupationRepository.delete(occupationDelete);
	}

}
