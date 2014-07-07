package com.web.londoncoffee.service;

import java.util.List;

import com.web.londoncoffee.model.CoffeeShop;

public interface ICoffeeShopService {

	public List<CoffeeShop> getCoffeeShopList();
	
	public CoffeeShop getCoffeeShop(int id);
	
	public void save(CoffeeShop coffeeShop);
	
	public void update(CoffeeShop coffeeShop);
	
	public void delete(int id);
}
