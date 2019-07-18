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

import com.everis.entities.ParentEntity;
import com.everis.serviceInterfaz.IParentsService;

@RestController
@RequestMapping(path="/Parent")
public class ParentController {

	@Autowired
	private IParentsService parentService;
	
	
	@PostMapping
	@RequestMapping(path="/Save")
	public ParentEntity createParent(@RequestBody ParentEntity parent) {
		return parentService.saveParent(parent);
	}
	
	@GetMapping(path="/FindAll")
	public List<ParentEntity> getParents() {
		return parentService.getParents();
	}

	@PutMapping(path="/Update")
	@ResponseStatus(HttpStatus.CREATED)
	public ParentEntity updateParent(@RequestBody ParentEntity parent) {
		return parentService.updateParent(parent);
	}

	@DeleteMapping(path="/Delete/{parent_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteParent(@PathVariable int parent_id) {
		parentService.deleteParent(parent_id);; 
	}
	
}
