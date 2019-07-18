package com.everis.serviceInterfaz;

import java.util.List;

import com.everis.entities.FamilyEntity;;

public interface IFamilyService {

	public FamilyEntity saveFamily(FamilyEntity family);
	
	public List<FamilyEntity> getFamiles();
	
	public FamilyEntity updateFamily(FamilyEntity family);
	
	public void deleteFamily(int family_id);
	
}
