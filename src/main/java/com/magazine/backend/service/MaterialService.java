package com.magazine.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magazine.backend.model.Material;
import com.magazine.backend.model.MaterialCategory;
import com.magazine.backend.repository.MaterialRepository;

@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	public Material saveMaterial(Material material) {		
		return materialRepository.save(material);
	}
	
	public Material findByTitle(String title) {
		return materialRepository.findByTitle(title);
	}
	
	public List<Material> findAll() {
		return (List<Material>) materialRepository.findAll();
	}

	public void deleteMaterial(Integer id) {
		materialRepository.deleteById(id);
	}
	
}
