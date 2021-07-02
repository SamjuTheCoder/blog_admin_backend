package com.magazine.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magazine.backend.model.Material;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer> {
	
	Material findByTitle(String title);

}
