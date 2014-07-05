package com.web.londoncoffee.dao;

import java.util.List;

import com.web.londoncoffee.model.CoffeeShop;

public interface ICoffeeShopDao {

	public List<CoffeeShop> getCoffeeShopList();
	
	public CoffeeShop getCoffeeShop(int id);
}
