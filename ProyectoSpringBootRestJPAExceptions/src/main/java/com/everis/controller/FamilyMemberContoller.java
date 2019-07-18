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

import com.everis.entities.FamilyMemberEntity;
import com.everis.serviceInterfaz.IFamilyMemberService;

@RestController
@RequestMapping("/FamilyMember")
public class FamilyMemberContoller {

	@Autowired
	private IFamilyMemberService familyMemberService;

	@PostMapping(path="/Save")
	@ResponseStatus(HttpStatus.CREATED)
	public FamilyMemberEntity createFamilyMember(@RequestBody FamilyMemberEntity familyMember) {
		return familyMemberService.saveFamilyMember(familyMember);
	}

	@GetMapping(path="/FindAll")
	public List<FamilyMemberEntity> getFamilyMembers() {
		return familyMemberService.getFamilyMembers();
	}

	@PutMapping(path="/Update")
	@ResponseStatus(HttpStatus.CREATED)
	public FamilyMemberEntity updateFamilyMember(@RequestBody FamilyMemberEntity familyMember) {
		return familyMemberService.updateFamilyMember(familyMember);
	}

	@DeleteMapping(path="/Delete/{familyMember_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFamilyMember(@PathVariable int familyMember_id) {
		familyMemberService.deleteFamilyMember(familyMember_id);
	}
	
}
