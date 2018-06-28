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

import com.example.demo.models.Clan;
import com.example.demo.models.ClanRepository;


@RestController
@RequestMapping("/clan")
@CrossOrigin(origins = "http://localhost:4200")
public class ClanController {
	
	@Autowired
	ClanRepository clanRepository;

	
	@GetMapping()
	public List<Clan> getClan() {
		return clanRepository.findAll();		
	}
	
	@PostMapping()
	public void createClan(@RequestBody Clan clan) {
		clanRepository.save(clan);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteClan(@PathVariable("id") int id) {
		Clan clanDelete = clanRepository.findById(id).orElse(null);
		clanRepository.delete(clanDelete);
	}
	
	

}
