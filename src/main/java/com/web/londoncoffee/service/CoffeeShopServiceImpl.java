package com.web.londoncoffee.service;

import java.util.List;

//import javax.transaction.Transactional;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.londoncoffee.dao.ICoffeeShopDao;
import com.web.londoncoffee.model.CoffeeShop;
import com.web.londoncoffee.service.ICoffeeShopService;

@Service
public class CoffeeShopServiceImpl implements ICoffeeShopService{

	@Autowired
	private ICoffeeShopDao coffeeShopDao;
	
	public CoffeeShopServiceImpl(){
		super();
	}
	
	public void setCoffeeShopDao(ICoffeeShopDao coffeeShopDao){
		this.coffeeShopDao = coffeeShopDao;
	}
	
	@Override
	@Transactional(readOnly=true)
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
