package com.magazine.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magazine.backend.model.MaterialCategory;
import com.magazine.backend.repository.MaterialCategoryRepository;

@Service
public class MaterialCategoryService {
	
	@Autowired
	private MaterialCategoryRepository materialCategoryRepository;
	
	public MaterialCategory findByCategory(String category) {
	
		return materialCategoryRepository.findByCategory(category);
	}
	
	public MaterialCategory saveMaterialCategory(MaterialCategory materialCategory) {
		
		return materialCategoryRepository.save(materialCategory);
	}
	
	public List<MaterialCategory> findAll() {
		
		return (List<MaterialCategory>) materialCategoryRepository.findAll();
	}

	public void deleteMaterialCategory(Integer id) {
		materialCategoryRepository.deleteById(id);
		
	}
}
