package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest {
    static CategoryDAO categoryDAO;
    @BeforeClass
    public static void initialize()
    {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	context.scan("com.ecomm.BckEndDemo");
    	context.refresh();
    	categoryDAO=(CategoryDAO)context.getBean("CategoryDAO");
    }
	@Test
	public void addCategorytest() {
		Category category=new Category();
		category.setCategoryName("Samsung Mobile");
		category.setCategoryDesc("All Smart Mobile of Samsung Brand");
		assertTrue("Problem in adding Category",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in deleting the category",categoryDAO.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategory()
	{
		Category category=categoryDAO.getCategory(3);
		category.setCategoryDesc("All the smart mobile");
		assertTrue("Problem in updating the category",categoryDAO.updateCategory(category));
	}
	@Test
	public void retriveCategories()
	{
		List<Category> listCategories=categoryDAO.listCategory();
		assertTrue("Problem in retrieving category",listCategories.size()>0);
		for(Category category:listCategories)
		{
			System.out.println(category.getCategoryId()+" ");
			System.out.println(category.getCategoryName()+" ");
			System.out.println(category.getCategoryDesc()+" ");
		}
	}

}
