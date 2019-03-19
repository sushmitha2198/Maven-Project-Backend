package com.ecomm.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm.config")

public class DBConfig {
     @Bean
     public DataSource getH2DataSource()
     {
    	 DriverManagerDataSource datasource=new DriverManagerDataSource();
    	 datasource.setDriverClassName("org.h2.Driver");
    	 datasource.setUrl("jdbc:h2:~/Demo");
    	 datasource.setUsername("sushmi");
    	 datasource.setPassword("sushmi");
    	 System.out.println("Datasorce object created");
    	 return datasource;
     }
     @Bean(name="SessionFactory")
     public SessionFactory getSessionFactory()
     {
    	 Properties hibernateprop=new Properties();
    	 hibernateprop.put("hibernate.hbm2ddl.auto","update");
    	 hibernateprop.put("hiberante.dialect", "org.hibernate.dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
    	 factory.addProperties(hibernateprop);
    	 SessionFactory sessionFactory=factory.buildSessionFactory();
    	 System.out.println("===SessionFactory Object Created===");
    	 return sessionFactory;
     }
     @Bean("txt Manager")
     public HibernateTransactionManager getHibernateTransaction(SessionFactory sessionFactory)
     {
    	 System.out.println("===Hiberante Transaction Manager===");
    	 return new HibernateTransactionManager(sessionFactory);
     }
}
