package com.web.londoncoffee.dao;

import java.util.List;

import com.web.londoncoffee.model.CoffeeShop;
/**
 * @author Chatitze Moumin
 *
 */
public interface ICoffeeShopDao {

	public List<CoffeeShop> getCoffeeShopList();
	
	public CoffeeShop getCoffeeShop(int id);
	
	public void save(CoffeeShop coffeeShop);
	
	public void update(CoffeeShop coffeeShop);
	
	public void delete(int id);
}
