package com.everis.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.entities.FamilyEntity;
import com.everis.repository.FamilyRepository;
import com.everis.serviceInterfaz.IFamilyService;

@Service
public class FamilyServiceImp implements IFamilyService {

	@Autowired
	FamilyRepository familyRepository;
	
	@Override
	public FamilyEntity saveFamily(FamilyEntity family) {
		return familyRepository.save(family);
	}

	@Override
	public List<FamilyEntity> getFamiles() {
		return familyRepository.findAll();
	}

	@Override
	public FamilyEntity updateFamily(FamilyEntity family) {
		
		FamilyEntity family_updated = null;
		
		// comprueba si la entidad para el id dado existe o no. 
		if(familyRepository.existsById(family.getFamily_id())) {
			family_updated = familyRepository.save(family);
		}
		
		return family_updated;
	}

	@Override
	public void deleteFamily(int family_id) {
		familyRepository.deleteById(family_id);
	}

}
