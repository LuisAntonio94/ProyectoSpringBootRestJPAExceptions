package com.everis.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.entities.ParentEntity;
import com.everis.repository.ParentRepository;
import com.everis.serviceInterfaz.IParentsService;

@Service
public class ParentServiceImp implements IParentsService {

	@Autowired
	ParentRepository parentRepository;
	
	@Override
	public ParentEntity saveParent(ParentEntity parent) {
		return parentRepository.save(parent);
	}

	@Override
	public List<ParentEntity> getParents() {
		return parentRepository.findAll();
	}

	@Override
	public ParentEntity updateParent(ParentEntity parent) {
		ParentEntity parent_updated = null;
		
		// comprueba si la entidad para el id dado existe o no. 
		if(parentRepository.existsById(parent.getParent_id())) {
			parent_updated = parentRepository.save(parent);
		}
		
		return parent_updated;
	}

	@Override
	public void deleteParent(int parent_id) {
		parentRepository.deleteById(parent_id);
	}

}
