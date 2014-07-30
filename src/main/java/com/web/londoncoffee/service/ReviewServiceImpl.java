package com.web.londoncoffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.londoncoffee.dao.IReviewDao;
import com.web.londoncoffee.model.Review;

/**
 * @author Chatitze Moumin
 *
 */
@Service
public class ReviewServiceImpl implements IReviewService{

	@Autowired
	public IReviewDao reviewDao;
	
	public ReviewServiceImpl() {
		super();
	}
	
	public ReviewServiceImpl(IReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	@Transactional(readOnly=true)
	public Review getReview(int id) {
		
		return reviewDao.getReview(id);
	}

}
