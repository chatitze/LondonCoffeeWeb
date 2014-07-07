package com.web.londoncoffee.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.londoncoffee.model.CoffeeShop;

@Repository
public class CoffeeShopDaoImpl implements ICoffeeShopDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public CoffeeShopDaoImpl(){
		super();
	}
	
	public CoffeeShopDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<CoffeeShop> getCoffeeShopList(){
		
		@SuppressWarnings("unchecked")
		//List<CoffeeShop> list = sessionFactory.getCurrentSession().createQuery("from lovecoffee.coffeeshop").list();
		/*List<CoffeeShop> list = (List<CoffeeShop>) sessionFactory.getCurrentSession()
								.createCriteria(CoffeeShop.class)
								.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		*/
		//List<CoffeeShop> list = sessionFactory.getCurrentSession().createQuery("from CoffeeShop").list();
		
		List<CoffeeShop> list =  sessionFactory.getCurrentSession().createCriteria(CoffeeShop.class).list();
		return  list;
	}

	@Override
	public CoffeeShop getCoffeeShop(int id) {
		return null;
	}
	
	
}
