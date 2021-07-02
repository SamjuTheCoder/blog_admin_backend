package com.magazine.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magazine.backend.model.News;
import com.magazine.backend.repository.NewsRepository;

@Service
public class NewsService {
	
	@Autowired
	private NewsRepository newsRepository;
	
	
	public News saveNews(News news) {
		return newsRepository.save(news);
	}
	
	public News findByTitle(String title) {
		return newsRepository.findByTitle(title);
	}
	
	public List<News> findAll() {
		return (List<News>) newsRepository.findAll();
	}
	
	public void deleteNews(Integer id) {
		newsRepository.deleteById(id);
	}

}
