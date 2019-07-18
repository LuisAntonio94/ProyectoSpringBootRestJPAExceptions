package com.everis.serviceInterfaz;

import java.util.List;

import com.everis.entities.FamilyMemberEntity;;

public interface IFamilyMemberService {

	public FamilyMemberEntity saveFamilyMember(FamilyMemberEntity familyMember);
	
	public List<FamilyMemberEntity> getFamilyMembers();
	
	public FamilyMemberEntity updateFamilyMember(FamilyMemberEntity familyMember);
	
	public void deleteFamilyMember(int familyMember_id);
	
}
