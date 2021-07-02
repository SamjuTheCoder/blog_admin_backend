package com.magazine.backend.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.magazine.backend.model.Material;
import com.magazine.backend.model.MaterialCategory;
import com.magazine.backend.model.News;
import com.magazine.backend.model.NewsCategory;
import com.magazine.backend.model.Register;
import com.magazine.backend.model.User;
import com.magazine.backend.service.MaterialCategoryService;
import com.magazine.backend.service.MaterialService;
import com.magazine.backend.service.NewsCategoryService;
import com.magazine.backend.service.NewsService;
import com.magazine.backend.service.RegisterService;
import com.magazine.backend.service.UserService;

@Controller
public class UserController {

 @Autowired
 private UserService userService;
 
 @Autowired
 private MaterialCategoryService materialCategoryService;
 
 @Autowired
 private NewsCategoryService newsCategoryService;
 
 @Autowired
 private MaterialService materialService;
 
 @Autowired
 private NewsService newsService;
 
 @Autowired
 private RegisterService registerService;
 
 @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
 public ModelAndView login() {
  ModelAndView model = new ModelAndView();
  
  model.setViewName("login");
  
  return model;
 }
 
 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
 public ModelAndView signup() {
  ModelAndView model = new ModelAndView();
  User user = new User();
  model.addObject("user", user);
  model.setViewName("signup");
  
  return model;
 }
 
 @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
 public ModelAndView createUser(User user, BindingResult bindingResult) {
  ModelAndView model = new ModelAndView();
  User userExists = userService.findUserByEmail(user.getEmail());
  
  if(userExists != null) {
   bindingResult.rejectValue("email", "error.user", "This email already exists!");
  }
  if(bindingResult.hasErrors()) {
   model.setViewName("signup");
  } else {
   userService.saveUser(user);
   model.addObject("msg", "User has been registered successfully!");
   model.addObject("user", new User());
   model.setViewName("signup");
  }
  
  return model;
 }
 
 @RequestMapping(value= {"/home"}, method=RequestMethod.GET)
 public ModelAndView home() {
  ModelAndView model = new ModelAndView();
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  User user = userService.findUserByEmail(auth.getName());
  
  model.addObject("userName", user.getFirstname() + " " + user.getLastname());
  model.setViewName("home");
  return model;
 }
 
 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
 public ModelAndView accessDenied() {
  ModelAndView model = new ModelAndView();
  model.setViewName("errors/access_denied");
  return model;
 }
 
 @RequestMapping( value="/material-category", method = RequestMethod.GET)
 public ModelAndView displayMategoryCategory() {
	 ModelAndView model = new ModelAndView("material_category");
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 User user = userService.findUserByEmail(auth.getName());
	 model.addObject("category", materialCategoryService.findAll());	  
	 model.addObject("userName", user.getFirstname() + " " + user.getLastname());

	 return model;	
 }
 
 @RequestMapping( value="/material-category", method = RequestMethod.POST)
 public ModelAndView createMaterialCategory(MaterialCategory materialCategory, BindingResult bindingResult) {
	  ModelAndView model = new ModelAndView();
	  MaterialCategory ifExists = materialCategoryService.findByCategory(materialCategory.getCategory());
	  
	  if(ifExists != null) {
		  bindingResult.rejectValue("category", "error.category", "This RECORD already exists!");
	  }
	  if(bindingResult.hasErrors()) {
	   model.setViewName("material_category");
	  } else {
		  materialCategoryService.saveMaterialCategory(materialCategory);
		  model.addObject("msg", "Category successfully saved!");
		  model.addObject("category", materialCategoryService.findAll());
		  model.setViewName("material_category");
	  }
	  
	  return model;
	 }
 
 @RequestMapping( value="/news-category", method = RequestMethod.GET)
 public ModelAndView displayNewsCategory() {
	 ModelAndView model = new ModelAndView("news_category");
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 User user = userService.findUserByEmail(auth.getName());
	 model.addObject("category", newsCategoryService.findAll());	  
	 model.addObject("userName", user.getFirstname() + " " + user.getLastname());

	 return model;
 }
 
 @RequestMapping( value="/news-category", method = RequestMethod.POST)
 public ModelAndView createNewsCategory(NewsCategory newsCategory, BindingResult bindingResult) {
	  ModelAndView model = new ModelAndView();
	  NewsCategory ifExists = newsCategoryService.findByCategory(newsCategory.getCategory());
	  
	  if(ifExists != null) {
		  bindingResult.rejectValue("category", "error.category", "This RECORD already exists!");
	  }
	  if(bindingResult.hasErrors()) {
	   model.setViewName("news_category");
	  } else {
		  newsCategoryService.saveNewsCategory(newsCategory);
		  model.addObject("msg", "Category successfully saved!");
		  model.addObject("category", newsCategoryService.findAll());
		  model.setViewName("news_category");
	  }
	  
	  return model;
	 }
 
 //saving material
 @RequestMapping( value="/material", method = RequestMethod.GET)
 public ModelAndView displayMaterial() {
	 ModelAndView model = new ModelAndView("material");
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 User user = userService.findUserByEmail(auth.getName());
	 model.addObject("title", materialService.findAll());	
	 model.addObject("category", materialCategoryService.findAll() );	
	 model.addObject("userName", user.getFirstname() + " " + user.getLastname());

	 return model;
 }
 
 @RequestMapping( value="/material", method = RequestMethod.POST)
 public ModelAndView createMaterial(Material material, BindingResult bindingResult) {
	  ModelAndView model = new ModelAndView();
	  Material ifExists = materialService.findByTitle(material.getTitle());
	  
	  if(ifExists != null) {
		  bindingResult.rejectValue("category", "error.category", "This RECORD already exists!");
	  }
	  if(bindingResult.hasErrors()) {
	   model.setViewName("material");
	  } else {
		  materialService.saveMaterial(material);
		  model.addObject("msg", "Successfully saved!");
		  model.addObject("title", materialService.findAll());
		  model.addObject("category", materialCategoryService.findAll() );
		  model.setViewName("material");
	  }
	  
	  return model;
	 }
 
 //view material
 @RequestMapping( value="/view-material", method = RequestMethod.GET)
 public ModelAndView viewMaterial() {
	 ModelAndView model = new ModelAndView("view_material");
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 User user = userService.findUserByEmail(auth.getName());
	 model.addObject("material", materialService.findAll());
	 model.addObject("category", materialCategoryService.findAll() );
	 model.addObject("userName", user.getFirstname() + " " + user.getLastname());

	 return model;
	
 	}
 
 //saving news
 @RequestMapping( value="/news", method = RequestMethod.GET)
 public ModelAndView displayNews() {
	 ModelAndView model = new ModelAndView("news");
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 User user = userService.findUserByEmail(auth.getName());
	 model.addObject("title", newsService.findAll());	
	 model.addObject("category", newsCategoryService.findAll() );	
	 model.addObject("userName", user.getFirstname() + " " + user.getLastname());

	 return model;
	
 }
 
 @RequestMapping( value="/news", method = RequestMethod.POST)
 public ModelAndView createNews(News news, BindingResult bindingResult) {
	  ModelAndView model = new ModelAndView();
	  News ifExists = newsService.findByTitle(news.getTitle());
	  
	  if(ifExists != null) {
		  bindingResult.rejectValue("category", "error.category", "This RECORD already exists!");
	  }
	  if(bindingResult.hasErrors()) {
	   model.setViewName("news");
	  } else {
		  newsService.saveNews(news);
		  model.addObject("msg", "Successfully saved!");
		  model.addObject("title", newsService.findAll());
		  model.addObject("category", newsCategoryService.findAll() );
		  model.setViewName("news");
	  }
	  
	  return model;
	 }
 
//view news
 @RequestMapping( value="/view-news", method = RequestMethod.GET)
 public ModelAndView viewNews() {
	 ModelAndView model = new ModelAndView("view_news");
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 User user = userService.findUserByEmail(auth.getName());
	 model.addObject("news", newsService.findAll());		
	 model.addObject("userName", user.getFirstname() + " " + user.getLastname());

	 return  model;
	
	}
 //delete news
 @RequestMapping( value="/delete-news", method = {RequestMethod.DELETE, RequestMethod.GET})
 public String deleteNews(Integer id) {
	  newsService.deleteNews(id);
	  
	  return "redirect:/view-news";
	
	}
 
 //delete material
 @RequestMapping( value="/delete-material", method = {RequestMethod.DELETE, RequestMethod.GET})
 public String deleteMaterial(Integer id) {
	  materialService.deleteMaterial(id);
	  
	  return "redirect:/view-material";
	
	}
 

 //delete-material-category
 @RequestMapping( value="/delete-material-category", method = {RequestMethod.DELETE, RequestMethod.GET})
 public String deleteMaterialCategory(Integer id) {
	  materialCategoryService.deleteMaterialCategory(id);
	  
	  return "redirect:/material-category";
	
	}
 
//delete-news-category
@RequestMapping( value="/delete-news-category", method = {RequestMethod.DELETE, RequestMethod.GET})
public String deleteNewsCategory(Integer id) {
	  newsCategoryService.deleteNewsCategory(id);
	  
	  return "redirect:/news-category";
	
	}

//register module
@RequestMapping( value="/register", method = RequestMethod.GET)
public ModelAndView showRegister() {
	 ModelAndView model = new ModelAndView("register");
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 User user = userService.findUserByEmail(auth.getName());
	 model.addObject("title", registerService.findAll());	
	 model.addObject("userName", user.getFirstname() + " " + user.getLastname());

	 return model;
	}

@RequestMapping( value="/register", method = RequestMethod.POST)
public ModelAndView createRegister(Register register, User user, BindingResult bindingResult) {
	  ModelAndView model = new ModelAndView();
	  Register ifExists = registerService.findByUsername(register.getUsername());
	  
	  if(ifExists != null) {
		  bindingResult.rejectValue("category", "error.category", "This RECORD already exists!");
	  }
	  if(bindingResult.hasErrors()) {
	   model.setViewName("register");
	  } else {
		  registerService.saveRegister(register);
		  userService.saveUser(user);
		  model.addObject("msg", "Successfully saved!");
		  model.addObject("title", registerService.findAll());
		  model.setViewName("register");
	  }
	  
	  return model;
	 }
}