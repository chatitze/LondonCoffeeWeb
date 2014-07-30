package com.web.londoncoffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.londoncoffee.dao.ICoffeeReviewsDao;
import com.web.londoncoffee.model.CoffeeReviews;

/**
 * @author Chatitze Moumin
 *
 */
@Service
public class CoffeeReviewsServiceImpl implements ICoffeeReviewsService{

	@Autowired
	public ICoffeeReviewsDao coffeeReviewsDao;
	
	public CoffeeReviewsServiceImpl() {
		super();
	}
	
	public CoffeeReviewsServiceImpl(ICoffeeReviewsDao coffeeReviewsDao) {
		this.coffeeReviewsDao = coffeeReviewsDao;
	}

	@Override
	@Transactional(readOnly=true)
	public List<CoffeeReviews> getCoffeeReviewList(int id) {
		
		return coffeeReviewsDao.getCoffeeReviewList(id);
	}

}
