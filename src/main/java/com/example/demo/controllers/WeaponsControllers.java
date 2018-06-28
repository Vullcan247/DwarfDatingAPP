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

import com.example.demo.models.Weapons;
import com.example.demo.models.WeaponsRepository;


@RestController
@RequestMapping("/weapons")
@CrossOrigin(origins = "http://localhost:4200")
public class WeaponsControllers {
	
	@Autowired
	WeaponsRepository weaponsRepository;

	
	@GetMapping()
	public List<Weapons> getWeapons() {
		return weaponsRepository.findAll();		
	}
	
	@PostMapping()
	public void createWeapons(@RequestBody Weapons weapons) {
		weaponsRepository.save(weapons);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteWeapons(@PathVariable("id") int id) {
		Weapons weaponsDelete = weaponsRepository.findById(id).orElse(null);
		weaponsRepository.delete(weaponsDelete);
	}
	
	

}