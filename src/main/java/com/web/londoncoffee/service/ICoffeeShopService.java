package com.web.londoncoffee.service;

import java.util.List;

import com.web.londoncoffee.model.CoffeeShop;

public interface ICoffeeShopService {

	public List<CoffeeShop> getCoffeeShopList();
	public CoffeeShop getCoffeeShop(int id);
}
