package com.magazine.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magazine.backend.model.NewsCategory;
import com.magazine.backend.repository.NewsCategoryRepository;

@Service
public class NewsCategoryService {
	
	@Autowired
	private NewsCategoryRepository newsCategoryRepository;
	
	public NewsCategory findByCategory(String category) {
		
		return newsCategoryRepository.findByCategory(category);
	}
	
	public NewsCategory saveNewsCategory(NewsCategory newsCategory) {
		
		return newsCategoryRepository.save(newsCategory);
	}
	
	public List<NewsCategory> findAll() {
		
		return (List<NewsCategory>) newsCategoryRepository.findAll();
	}

	public void deleteNewsCategory(Integer id) {
		newsCategoryRepository.deleteById(id);;
		
	}

}
