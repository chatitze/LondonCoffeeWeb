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
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.web.londoncoffee.dao.CoffeeReviewsDaoImpl;
import com.web.londoncoffee.dao.CoffeeShopDaoImpl;
import com.web.londoncoffee.dao.ICoffeeReviewsDao;
import com.web.londoncoffee.dao.ICoffeeShopDao;
import com.web.londoncoffee.dao.ILocationDao;
import com.web.londoncoffee.dao.IReviewDao;
import com.web.londoncoffee.dao.ISocialMediaDao;
import com.web.londoncoffee.dao.LocationDaoImpl;
import com.web.londoncoffee.dao.ReviewDaoImpl;
import com.web.londoncoffee.dao.SocialMediaDaoImpl;
import com.web.londoncoffee.model.CoffeeReviews;
import com.web.londoncoffee.model.CoffeeShop;
import com.web.londoncoffee.model.Location;
import com.web.londoncoffee.model.Review;
import com.web.londoncoffee.model.SocialMedia;
import com.web.londoncoffee.service.CoffeeReviewsServiceImpl;
import com.web.londoncoffee.service.CoffeeShopServiceImpl;
import com.web.londoncoffee.service.ICoffeeReviewsService;
import com.web.londoncoffee.service.ICoffeeShopService;
import com.web.londoncoffee.service.ILocationService;
import com.web.londoncoffee.service.IReviewService;
import com.web.londoncoffee.service.ISocialMediaService;
import com.web.londoncoffee.service.LocationServiceImpl;
import com.web.londoncoffee.service.ReviewServiceImpl;
import com.web.londoncoffee.service.SocialMediaServiceImpl;
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
    	sessionBuilder.addAnnotatedClasses(Location.class);
    	sessionBuilder.addAnnotatedClasses(SocialMedia.class);
    	sessionBuilder.addAnnotatedClasses(Review.class);
    	sessionBuilder.addAnnotatedClasses(CoffeeReviews.class);
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
    
    @Autowired
    @Bean(name = "locationDao")
    public ILocationDao getLocationDao(SessionFactory sessionFactory) {
    	return new LocationDaoImpl(sessionFactory);
    }
    
    @Autowired
    @Bean(name = "locationService")
    public ILocationService getLocationService(ILocationDao locationDao) {
    	return new LocationServiceImpl(locationDao);
    }
    
    @Autowired
    @Bean(name = "socialMediaDao")
    public ISocialMediaDao getSocialMediaDao(SessionFactory sessionFactory) {
    	return new SocialMediaDaoImpl(sessionFactory);
    }
    
    @Autowired
    @Bean(name = "socialMediaService")
    public ISocialMediaService getSocialMediaService(ISocialMediaDao socialMediaDao) {
    	return new SocialMediaServiceImpl(socialMediaDao);
    }
    
    @Autowired
    @Bean(name = "reviewDao")
    public IReviewDao getReviewDao(SessionFactory sessionFactory) {
    	return new ReviewDaoImpl(sessionFactory);
    }
    
    @Autowired
    @Bean(name = "reviewService")
    public IReviewService getReviewService(IReviewDao reviewDao) {
    	return new ReviewServiceImpl(reviewDao);
    }
    
    @Autowired
    @Bean(name = "coffeeReviewsDao")
    public ICoffeeReviewsDao getCoffeeReviewsDao(SessionFactory sessionFactory) {
    	return new CoffeeReviewsDaoImpl(sessionFactory);
    }
    
    @Autowired
    @Bean(name = "coffeeReviewsService")
    public ICoffeeReviewsService getCoffeeReviewsService(ICoffeeReviewsDao coffeeReviewsDao) {
    	return new CoffeeReviewsServiceImpl(coffeeReviewsDao);
    }
}
