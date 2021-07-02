package com.magazine.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magazine.backend.model.NewsCategory;

@Repository
public interface NewsCategoryRepository extends CrudRepository<NewsCategory, Integer> {
	
	NewsCategory findByCategory(String category);

}
