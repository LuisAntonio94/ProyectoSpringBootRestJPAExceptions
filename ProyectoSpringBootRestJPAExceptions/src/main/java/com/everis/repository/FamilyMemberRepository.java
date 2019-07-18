package com.everis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.entities.FamilyMemberEntity;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMemberEntity, Integer> {
	
}
