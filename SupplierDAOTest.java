package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Supplier;

public class SupplierDAOTest {
   static SupplierDAO supplierDAO;
   @BeforeClass
   public static void executeFirst()
   {
	   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	   context.scan("org.pro");
	   context.refresh();
	   supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
   }
   @Ignore
   @Test
   public void addCategoryTest()
   {
	   Supplier supplier=new Supplier();
	   supplier.setSupplierName("Sushmitha");
	   supplier.setSupplierAddress("Chennai");
	   assertTrue("problem in adding the category",supplierDAO.update(supplier));
	   
   }
   public void listCategoriesTest()
   {
	   List<Supplier> listSupplier=supplierDAO.listSupplier();
	   assertTrue("problem in adding the category",listSupplier.size()>0);
	   for(Supplier supplier:listSupplier)
	   {
		   System.out.println(listSupplier);
	   }
   }
}
