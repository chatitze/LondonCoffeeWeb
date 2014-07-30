package com.web.londoncoffee.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.londoncoffee.model.Review;

/**
 * @author Chatitze Moumin
 *
 */
@Repository
public class ReviewDaoImpl implements IReviewDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ReviewDaoImpl() {
		super();
	}
	
	public ReviewDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Review getReview(int id) {
		return (Review) sessionFactory.getCurrentSession()
				.createCriteria(Review.class)
				.add(Restrictions.idEq(id))
				.uniqueResult();
	}

}
