package com.web.londoncoffee.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.londoncoffee.model.CoffeeShop;
import com.web.londoncoffee.service.ICoffeeShopService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ICoffeeShopService coffeeShopService;
	
	@Resource(name="myCoffeeShopService")
	public void setCoffeeShopService(ICoffeeShopService coffeeShopService){
		this.coffeeShopService = coffeeShopService;
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
	
	@RequestMapping(value = "/venuelist", method = RequestMethod.GET)
	public String getCoffeeShopList(Locale locale, Model model) {
		logger.info("Coffee Shop List!");
		
		List<CoffeeShop> coffeShopList = coffeeShopService.getCoffeeShopList();
		
		//-------------------------- sil --------------------------------
		/*CoffeeShop cof = new CoffeeShop();
		cof.setName("Prufrock");
		cof.setRating(4.4);
		cof.setWebAddress("www.prufrock.co.uk");
		coffeShopList = new ArrayList<CoffeeShop>();
		coffeShopList.add(cof);
		
		cof = new CoffeeShop();
		cof.setName("Kaffeine");
		cof.setRating(4.6);
		cof.setWebAddress("www.kaffeine.co.uk");
		coffeShopList.add(cof);*/
		//----------------------------------------------------------------
		
		model.addAttribute("COFFEESHOP_LIST", coffeShopList);
		
		return "coffeeShopList";
	}
	
	
	@RequestMapping(value = "/venue/{coffeeshopId}", method = RequestMethod.GET)
	public String getCoffeeShop(@PathVariable int coffeeshopId, ModelMap model) {
		logger.info("Coffee Shop!");
	/*
		CoffeeShop coffeShop = coffeeShopService.getCoffeeShop(coffeeshopId);
		
		//-------------------------- sil --------------------------------
		coffeShop = new CoffeeShop();
		coffeShop.setName("Prufrock");
		coffeShop.setRating(4.4);
		coffeShop.setWebAddress("www.prufrock.co.uk");
		
		//----------------------------------------------------------------
		
				
		model.addAttribute("COFFEESHOP", coffeShop);
		*/
		return "venue";
	}
	
}
