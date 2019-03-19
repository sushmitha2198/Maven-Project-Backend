package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

public class UserDAOTest {
   static UserDAO userDAO;
   @BeforeClass
   public static void initialize()
   {
	   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	   context.scan("com.ecomm");
	   context.refresh();
	   userDAO=(UserDAO)context.getBean("UserDAO");
   }
   @Ignore
   @Test
   public void registerUserTest()
   {
	   UserDetail user=new UserDetail();
	   user.setUsername("sushmi");
	   user.setPassword("sushmi");
	   user.setCustomerName("SUSHMITHA");
	   user.setEnable("true");
	   user.setAddress("Chennai");
	   user.setRole("ROLE_USER");
	   assertTrue("Problem in adding the user",userDAO.registerUser(user));
   }
   @Test
   public void updateUserTest()
   {
	   UserDetail user=userDAO.getUser("sushmi");
	   user.setPassword("sushmi");
	   assertTrue("problem in updating the user",userDAO.updateUser(user));
   }
}
