package com.web.londoncoffee.spring.config;

import java.util.Properties;

import javax.sql.DataSource;



//import org.apache.commons.dbcp.BasicDataSource;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.web.londoncoffee.dao.CoffeeShopDaoImpl;
import com.web.londoncoffee.dao.ICoffeeShopDao;
import com.web.londoncoffee.model.CoffeeShop;
import com.web.londoncoffee.service.CoffeeShopServiceImpl;
import com.web.londoncoffee.service.ICoffeeShopService;
/**
 * @author Chatitze Moumin
 *
 */
@Configuration
@ComponentScan("com.web.londoncoffee")
//Enables Spring's annotations 
@EnableWebMvc
@EnableTransactionManagement
public class ApplicationContextConfig {

	/*
	 //1
	@Bean  
    public UrlBasedViewResolver setupViewResolver() {  
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
        resolver.setPrefix("/WEB-INF/views/");  
        resolver.setSuffix(".jsp");  
        resolver.setViewClass(JstlView.class);  
        return resolver;  
    }
	*/
	//2
	@Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	//2
	@Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/lovecoffee");
    	dataSource.setUsername("root");
    	dataSource.setPassword("root");
    	
    	return dataSource;
    }
	//2
	private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	//properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    	return properties;
    }
    //2
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(CoffeeShop.class);
    	return sessionBuilder.buildSessionFactory();
    }
    /*
    //3
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
       LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
       sessionFactory.setDataSource(getDataSource());
       sessionFactory.setPackagesToScan(new String[] { "org.baeldung.spring.persistence.model" });
       sessionFactory.setHibernateProperties(hibernateProperties());
  
       return sessionFactory;
    }
    //3
    Properties hibernateProperties() {
        return new Properties() {
           {
              setProperty("hibernate.hbm2ddl.auto", "create-drop");
              setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
              setProperty("hibernate.globally_quoted_identifiers", "true");
           }
        };
     }
    */
    
    
    @Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory); //2
		//HibernateTransactionManager txManager = new HibernateTransactionManager(); //3
		//txManager.setSessionFactory(sessionFactory); //3
		return transactionManager;
	}
    
    @Autowired
    @Bean(name = "coffeeShopDao")
    public ICoffeeShopDao getCoffeeShopDao(SessionFactory sessionFactory) {
    	return new CoffeeShopDaoImpl(sessionFactory);
    }
    
    @Autowired
    @Bean(name = "coffeeShopService")
    public ICoffeeShopService getCoffeeShopservice(ICoffeeShopDao coffeeShopDao) {
    	return new CoffeeShopServiceImpl(coffeeShopDao);
    }
}
