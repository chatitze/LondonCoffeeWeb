package com.web.londoncoffee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.londoncoffee.model.CoffeeReviews;

/**
 * @author Chatitze Moumin
 *
 */
@Repository
public class CoffeeReviewsDaoImpl implements ICoffeeReviewsDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public CoffeeReviewsDaoImpl() {
		super();
	}
	
	public CoffeeReviewsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CoffeeReviews> getCoffeeReviewList(int id) {
		
		@SuppressWarnings("unchecked")
		List<CoffeeReviews> list =  sessionFactory.getCurrentSession().createCriteria(CoffeeReviews.class)
				.add(Restrictions.eq("coffeeShopId", id))
				.list();
		
		return list;
	}
}

