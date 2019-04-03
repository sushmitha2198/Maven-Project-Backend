package com.ecomm.controller;

import java.util.List;

import javax.transaction.Transactional;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@ComponentScan("com.ecomm.*")
@Transactional
@Controller
public class CategoryController
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/category")
	public String showCategory(Model l)
	{   
		List<Category> listCategories=categoryDAO.listCategory();
		l.addAttribute("Categories", listCategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("categoryName")String categoryName,@RequestParam("categoryDescription")String categoryDescription,Model l)
	{
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDescription);
		categoryDAO.addCategory(category);
		List<Category> listCategories=categoryDAO.listCategory();
		l.addAttribute("Categories",listCategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model l)
	{
		Category category = categoryDAO.getCategory(categoryId);
		l.addAttribute("category",category);
		List<Category> listCategories=categoryDAO.listCategory();
		l.addAttribute("Categories", listCategories);
		return "Updatecategory";
	}
	
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryId")int categoryId,@RequestParam("categoryName")String Name,@RequestParam("categorydescription")String Description,Model l)
	{
		Category category = categoryDAO.getCategory(categoryId);
		category.setCategoryName(Name);
		category.setCategoryDesc(Description);
		
		categoryDAO.updateCategory(category);
		
		List<Category> listcate=categoryDAO.listCategory();
		l.addAttribute("Categories", listcate);

		return "Category";
	}
	
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deletCategory(@PathVariable("categoryId")int categoryId,Model l)
	{
		Category category = categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		
		List<Category> listdata=categoryDAO.listCategory();
		l.addAttribute("Categories", listdata);
		
		return "Category";
	}
}
