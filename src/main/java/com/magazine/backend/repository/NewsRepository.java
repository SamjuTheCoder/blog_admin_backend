package com.magazine.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magazine.backend.model.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer>{
	
	public News findByTitle(String title);

}
