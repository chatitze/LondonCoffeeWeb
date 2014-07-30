package com.web.londoncoffee.controller;
/**
 * @author Chatitze Moumin
 *
 */
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.londoncoffee.model.CoffeeReviews;
import com.web.londoncoffee.model.CoffeeShop;
import com.web.londoncoffee.service.ICoffeeReviewsService;
import com.web.londoncoffee.service.ICoffeeShopService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ICoffeeShopService coffeeShopService;
	
	@Autowired
	private ICoffeeReviewsService coffeeReviewsService;
	
	@Resource(name="coffeeShopService")
	public void setCoffeeShopService(ICoffeeShopService coffeeShopService){
		this.coffeeShopService = coffeeShopService;
	}
	
	@Resource(name="coffeeReviewsService")
	public void setCoffeeReviewsService(ICoffeeReviewsService coffeeReviewsService){
		this.coffeeReviewsService = coffeeReviewsService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * GET Coffee Shop details
	 * @return coffee shop details with specified id
	 */
	@RequestMapping(value = "/venue/{coffeeshopId}", method = RequestMethod.GET)
	public String getCoffeeShop(@PathVariable int coffeeshopId, ModelMap model) {
		logger.info("Coffee Shop!");
	
		CoffeeShop coffeShop = coffeeShopService.getCoffeeShop(coffeeshopId);
		
		List<CoffeeReviews> coffeReviewsList = coffeeReviewsService.getCoffeeReviewList(coffeeshopId);
		
		model.addAttribute("COFFEESHOP", coffeShop);
		model.addAttribute("COFFEEREVIEW_LIST", coffeReviewsList);
		return "venue";
	}
	
	/**
	 * GET Coffee Shops List
	 * @return all the coffee shops
	 */
	@RequestMapping(value = "/venuelist", method = RequestMethod.GET)
	public String getCoffeeShopList(Locale locale, Model model) {
		logger.info("Coffee Shop List!");
		
		List<CoffeeShop> coffeShopList = coffeeShopService.getCoffeeShopList();
		
		model.addAttribute("COFFEESHOP_LIST", coffeShopList);
		
		return "coffeeShopList";
	}
	
	/**
	 * Add a new coffee shop
	 */
	@RequestMapping(value = "/venue", method = RequestMethod.POST)
	public String saveCoffeeShop(@ModelAttribute("coffeeShop") CoffeeShop coffeeShop, BindingResult result) {
		logger.info("Coffee Shop to add:" + coffeeShop.getName());
	
		coffeeShop.setName("Artisan");
		coffeeShop.setRating(4.4);
		coffeeShop.setWebAddress("www.artisan.coffee");
		
		coffeeShopService.save(coffeeShop);
		
		return "saved";
	}
}
