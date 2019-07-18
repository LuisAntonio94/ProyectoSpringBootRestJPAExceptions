package com.everis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.everis.entities.FamilyEntity;
import com.everis.serviceInterfaz.IFamilyService;

@RestController
@RequestMapping(path="/Family")
public class FamilyController {

	@Autowired
	private IFamilyService familyService;

	@PostMapping(path="/Save")
	@ResponseStatus(HttpStatus.CREATED)
	public FamilyEntity createFamily(@RequestBody FamilyEntity family) {
		return familyService.saveFamily(family);
	}

	@GetMapping(path="/FindAll")
	public List<FamilyEntity> getFamilies() {
		return familyService.getFamiles();
	}

	@PutMapping(path="/Update")
	@ResponseStatus(HttpStatus.CREATED)
	public FamilyEntity updateFamily(@RequestBody FamilyEntity family) {
		return familyService.updateFamily(family);
	}

	@DeleteMapping(path="/Delete/{family_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFamily(@PathVariable int family_id) {
		familyService.deleteFamily(family_id);; 
	}
	
}
