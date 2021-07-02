package com.magazine.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "tblnews")
public class News {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String title;
	private String content;
	private String category_id;
	
	@CreationTimestamp
	private Date datetime;
	
	@ManyToOne
	private NewsCategory newscategory;
	
	public News() {
		
	}
	
	public News(int id, String title, String content, Date datetime,String category_id) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.datetime = datetime;
		this.category_id=category_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	

}
