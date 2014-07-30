package com.web.londoncoffee.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.londoncoffee.model.CoffeeReviews;
import com.web.londoncoffee.model.CoffeeShop;
import com.web.londoncoffee.service.ICoffeeReviewsService;
import com.web.londoncoffee.service.ICoffeeShopService;
import com.web.londoncoffee.service.ILocationService;
import com.web.londoncoffee.service.IReviewService;
import com.web.londoncoffee.service.ISocialMediaService;

/**
 * @author Chatitze Moumin
 *
 */
@Controller
@RequestMapping("/rest")
public class CoffeeShopController {

	private static final Logger logger = LoggerFactory.getLogger(CoffeeShopController.class);
	
	@Autowired
	private ICoffeeShopService coffeeShopService;
	
	@Autowired
	private ILocationService locationService;
	
	@Autowired
	private ISocialMediaService socialMediaService;
	
	@Autowired
	private IReviewService reviewService;
	
	@Autowired
	private ICoffeeReviewsService coffeeReviewsService;
	
	@Resource(name="coffeeShopService")
	public void setCoffeeShopService(ICoffeeShopService coffeeShopService){
		this.coffeeShopService = coffeeShopService;
	}
	
	@Resource(name="locationService")
	public void setLocationService(ILocationService locationService){
		this.locationService = locationService;
	}
	
	@Resource(name="socialMediaService")
	public void setSocialMediaService(ISocialMediaService socialMediaService){
		this.socialMediaService = socialMediaService;
	}
	
	@Resource(name="reviewService")
	public void setReviewService(IReviewService reviewService){
		this.reviewService = reviewService;
	}
	
	@Resource(name="coffeeReviewsService")
	public void setCoffeeReviewsService(ICoffeeReviewsService coffeeReviewsService){
		this.coffeeReviewsService = coffeeReviewsService;
	}
	
	/**
	 * GET Coffee Shop details
	 * @return coffee shop details with specified id
	 */
	@RequestMapping(value = "/venue/{coffeeshopId}", method = RequestMethod.GET, headers="accept=application/json")
	public @ResponseBody CoffeeShop getCoffeeShop(@PathVariable int coffeeshopId) {
		logger.info("Coffee Shop!");
		
		CoffeeShop coffeShop = coffeeShopService.getCoffeeShop(coffeeshopId);
		
		return coffeShop;
	}
	
	/**
	 * GET Coffee Shops List
	 * @return all the coffee shops
	 */
	@RequestMapping(value = "/venuelist", method = RequestMethod.GET)
	public @ResponseBody List<CoffeeShop> getCoffeeShopList() {
		logger.info("Coffee Shop List!");
		
		List<CoffeeShop> coffeShopList = coffeeShopService.getCoffeeShopList();
		
		return coffeShopList;
	}

	/**
	 * GET Coffee Shops Reviews
	 * @return all reviews for a given coffee shops
	 */
	@RequestMapping(value = "/venueReviews/{coffeeshopId}", method = RequestMethod.GET)
	public @ResponseBody List<CoffeeReviews> getCoffeeReviewsList(@PathVariable int coffeeShopId) {
		logger.info("Coffee Shop Reviews!");
		
		List<CoffeeReviews> coffeReviewsList = coffeeReviewsService.getCoffeeReviewList(coffeeShopId);
		
		return coffeReviewsList;
	}
	
	/**
	 * Add a new coffee shop
	 */
	@RequestMapping(value = "/venue", method = RequestMethod.POST)
	public void saveCoffeeShop(@ModelAttribute("coffeeShop") CoffeeShop coffeeShop, BindingResult result) {
		logger.info("Coffee Shop to add:" + coffeeShop.getName());
		
		coffeeShopService.save(coffeeShop);
	}
	
	/**
	 * Update an existing coffee shop
	 */
	@RequestMapping(value = "/venue/{coffeeshopId}", method = RequestMethod.PUT)
	public void updateCoffeeShop(@PathVariable int coffeeshopId, @ModelAttribute("coffeeShop") CoffeeShop coffeeShop, BindingResult result) {
		logger.info("Coffee Shop to update:" + coffeeShop.getName());
	
		coffeeShopService.update(coffeeShop);

	}
	
	/**
	 * Delete an existing coffee shop
	 */
	@RequestMapping(value = "/venue/{coffeeshopId}", method = RequestMethod.DELETE)
	public void deleteCoffeeShop(@PathVariable int coffeeshopId, BindingResult result) {
		logger.info("Coffee Shop to update:" + coffeeshopId);
	
		coffeeShopService.delete(coffeeshopId);

	}
}
