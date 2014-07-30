package com.web.londoncoffee.dao;

import java.util.List;

import com.web.londoncoffee.model.CoffeeReviews;

/**
 * @author Chatitze Moumin
 *
 */
public interface ICoffeeReviewsDao {

	List<CoffeeReviews> getCoffeeReviewList(int id);
}
