package com.web.londoncoffee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Chatitze Moumin
 *
 */
@Entity
public class CoffeeReviews implements Serializable{

	private static final long serialVersionUID = -4076080928108113132L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "coffeeshop_id")
	private int coffeeShopId;
	
	@Column(name = "review_id", unique = false, insertable = false, updatable = false)
	private int reviewId;
	
	@OneToOne
	private Review review;

	public CoffeeReviews(){
		super();
	}
	
	public CoffeeReviews(int id, int coffeeShopId, int reviewId,
			CoffeeShop coffeeShop, Review review) {
		super();
		this.id = id;
		this.coffeeShopId = coffeeShopId;
		this.reviewId = reviewId;
		this.review = review;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCoffeeShopId() {
		return coffeeShopId;
	}

	public void setCoffeeShopId(int coffeeShopId) {
		this.coffeeShopId = coffeeShopId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

}
