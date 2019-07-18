package com.everis.serviceInterfaz;

import java.util.List;

import com.everis.entities.ParentEntity;;

public interface IParentsService {

	public ParentEntity saveParent(ParentEntity parent);
	
	public List<ParentEntity> getParents();
	
	public ParentEntity updateParent(ParentEntity parent);
	
	public void deleteParent(int parent_id);
	
}
