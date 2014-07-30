package com.web.londoncoffee.service;

import java.util.List;

import com.web.londoncoffee.model.CoffeeReviews;

/**
 * @author Chatitze Moumin
 *
 */
public interface ICoffeeReviewsService {

	List<CoffeeReviews> getCoffeeReviewList(int id);
}
