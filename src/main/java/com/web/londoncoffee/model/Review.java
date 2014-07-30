package com.web.londoncoffee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author Chatitze Moumin
 *
 */

@Entity
public class Review implements Serializable{

	private static final long serialVersionUID = 5036728837583283210L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "sourceAddress")
	private String sourceAddress;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "review")
	private String review;

	@OneToOne
    @PrimaryKeyJoinColumn
	private CoffeeReviews coffeeReviews;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public CoffeeReviews getCoffeeShopReview() {
		return coffeeReviews;
	}

	public void setCoffeeShopReview(CoffeeReviews coffeeReviews) {
		this.coffeeReviews = coffeeReviews;
	}
	
	
}
