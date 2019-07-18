package com.everis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.entities.FamilyEntity;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyEntity, Integer> {

}
