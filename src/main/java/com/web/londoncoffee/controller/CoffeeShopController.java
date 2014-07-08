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

import com.web.londoncoffee.model.CoffeeShop;
import com.web.londoncoffee.service.ICoffeeShopService;

/**
 * @author Chatitze Moumin
 *
 */
@Controller
@RequestMapping("/rest")
public class CoffeeShopController {

	private static final Logger logger = LoggerFactory.getLogger(CoffeeShopControllerTest.class);
	
	@Autowired
	private ICoffeeShopService coffeeShopService;
	
	@Resource(name="coffeeShopService")
	public void setCoffeeShopService(ICoffeeShopService coffeeShopService){
		this.coffeeShopService = coffeeShopService;
	}
	
	/**
	 * GET Coffee Shop details
	 * @return coffee shop details with specified id
	 */
	@RequestMapping(value = "/venue/{coffeeshopId}", method = RequestMethod.GET, headers="accept=application/json")
	public @ResponseBody CoffeeShop getVenue(@PathVariable int coffeeshopId) {
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
