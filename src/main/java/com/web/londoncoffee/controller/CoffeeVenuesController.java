package com.web.londoncoffee.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.londoncoffee.model.CoffeeShop;
import com.web.londoncoffee.service.ICoffeeShopService;

@Controller
public class CoffeeVenuesController {

	private static final Logger logger = LoggerFactory.getLogger(CoffeeVenuesController.class);
	
	private ICoffeeShopService coffeeShopService;
	
	@Resource(name="myCoffeeShopService")
	public void setCoffeeShopService(ICoffeeShopService coffeeShopService){
		this.coffeeShopService = coffeeShopService;
	}
	
	@RequestMapping(value = "/venue", method = RequestMethod.GET, headers="accept=application/json")
	public @ResponseBody CoffeeShop getVenue() {
		logger.info("Coffee Shop!");
		
		CoffeeShop coffeShop = coffeeShopService.getCoffeeShop(5);
		
		//-------------------------- sil --------------------------------
		coffeShop = new CoffeeShop();
		coffeShop.setName("Prufrock");
		coffeShop.setRating(4.4);
		coffeShop.setWebAddress("www.prufrock.co.uk");
		
		//----------------------------------------------------------------
				
		
		return coffeShop;
	}
	
}
