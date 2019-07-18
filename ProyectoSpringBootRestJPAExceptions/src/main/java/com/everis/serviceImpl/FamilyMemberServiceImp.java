package com.everis.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.entities.FamilyMemberEntity;
import com.everis.repository.FamilyMemberRepository;
import com.everis.serviceInterfaz.IFamilyMemberService;

@Service
public class FamilyMemberServiceImp implements IFamilyMemberService{

	@Autowired
	FamilyMemberRepository familyMemberRepository;

	
	@Override
	public FamilyMemberEntity saveFamilyMember(FamilyMemberEntity familyMember) {
		return familyMemberRepository.save(familyMember);
	}

	@Override
	public List<FamilyMemberEntity> getFamilyMembers() {
		return familyMemberRepository.findAll();
	}

	@Override
	public FamilyMemberEntity updateFamilyMember(FamilyMemberEntity familyMember) {
		FamilyMemberEntity familyMember_updated = null;
		
		// comprueba si la entidad para el id dado existe o no. 
		if(familyMemberRepository.existsById(familyMember.getFamily_member_id())) {
			familyMember_updated = familyMemberRepository.save(familyMember);
		}
		
		return familyMember_updated;
	}

	@Override
	public void deleteFamilyMember(int familyMember_id) {
		familyMemberRepository.deleteById(familyMember_id);
	}

}
