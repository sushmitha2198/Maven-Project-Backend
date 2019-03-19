package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest {
     static ProductDAO productDAO;
     @BeforeClass
     public static void initialize()
     {
    	 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	 context.scan("com.ecomm");
    	 context.refresh();
    	 productDAO=(ProductDAO)context.getBean("ProductDAO");
     }
	private int List;
     @Ignore
     @Test
     public void addProductTest()
     {
    	 Product product=new Product();
    	 product.setProductName("Samsung J7");
    	 product.setProductDesc("The mobile with 4G & NFS features");
    	 product.setStock(20);
    	 product.setPrice(12000);
    	 product.setCategoryId(1);
    	 product.setSupplierId(6);
    	 assertTrue("Problem in adding the product",productDAO.addProduct(product));
     }
     @Ignore
     @Test
     public void deleteProductTest()
     {
    	 Product product=productDAO.getProduct(6);
    	 assertTrue("Problem in Deleting the product",productDAO.deleteProduct(product));
     }
     @Ignore
     @Test
     public void updateProductTest()
     {
    	 Product product=productDAO.getProduct(7);
    	 product.setPrice(11000);
    	 product.setStock(15);
    	 assertTrue("Problem in updating the product",productDAO.updateProduct(product));
     }
     @Test
     public void listProductTest()
     {
		List<Product> listProducts=productDAO.listProduct();
    	 assertTrue("Problem in retrieving the Product",listProducts.size()>0);
    	 for(Product product:listProducts)
    	 {
    		 System.out.println(product.getProductName()+" ");
    		 System.out.println(product.getProductDesc()+" ");
    		 System.out.println(product.getStock()+" ");
    		 System.out.println(product.getPrice()+" ");
    	 }
     }
     
}
