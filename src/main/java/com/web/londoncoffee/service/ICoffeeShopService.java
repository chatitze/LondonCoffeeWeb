package com.web.londoncoffee.service;

import java.util.List;

import com.web.londoncoffee.model.CoffeeShop;
/**
 * @author Chatitze Moumin
 *
 */
public interface ICoffeeShopService {

	public List<CoffeeShop> getCoffeeShopList();
	
	public CoffeeShop getCoffeeShop(int id);
	
	public int save(CoffeeShop coffeeShop);
	
	public void update(CoffeeShop coffeeShop);
	
	public void delete(int id);
}
