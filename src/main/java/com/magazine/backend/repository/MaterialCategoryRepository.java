package com.magazine.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magazine.backend.model.MaterialCategory;
import com.magazine.backend.model.User;

@Repository
public interface MaterialCategoryRepository extends CrudRepository<MaterialCategory, Integer> {
	MaterialCategory findByCategory(String category);
}
