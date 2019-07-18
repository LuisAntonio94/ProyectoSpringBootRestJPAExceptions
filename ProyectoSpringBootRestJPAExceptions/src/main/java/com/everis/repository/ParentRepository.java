package com.everis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.entities.ParentEntity;

@Repository
public interface ParentRepository extends JpaRepository<ParentEntity, Integer> {

}
