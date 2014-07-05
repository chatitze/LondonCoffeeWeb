package com.web.londoncoffee.service.impl;

import java.util.List;

import com.web.londoncoffee.dao.ICoffeeShopDao;
import com.web.londoncoffee.model.CoffeeShop;
import com.web.londoncoffee.service.ICoffeeShopService;

public class CoffeeShopServiceImpl implements ICoffeeShopService{

	private ICoffeeShopDao coffeeShopDao;
	
	public void setCoffeeShopDao(ICoffeeShopDao coffeeShopDao){
		this.coffeeShopDao = coffeeShopDao;
	}
	
	@Override
	public List<CoffeeShop> getCoffeeShopList(){
		List<CoffeeShop> coffeeShops = coffeeShopDao.getCoffeeShopList();
		return coffeeShops;
	}

	@Override
	public CoffeeShop getCoffeeShop(int id) {
		CoffeeShop coffeeShop = coffeeShopDao.getCoffeeShop(id);
		return coffeeShop;
	}
}
