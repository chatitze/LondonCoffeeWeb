package com.web.londoncoffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.londoncoffee.dao.ICoffeeShopDao;
import com.web.londoncoffee.model.CoffeeShop;
/**
 * @author Chatitze Moumin
 *
 */
@Service
public class CoffeeShopServiceImpl implements ICoffeeShopService{

	@Autowired
	private ICoffeeShopDao coffeeShopDao;
	
	public CoffeeShopServiceImpl(){
		super();
	}
	
	public CoffeeShopServiceImpl(ICoffeeShopDao coffeeShopDao){
		this.coffeeShopDao = coffeeShopDao;
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
	@Transactional(readOnly=true)
	public CoffeeShop getCoffeeShop(int id) {
		CoffeeShop coffeeShop = coffeeShopDao.getCoffeeShop(id);
		return coffeeShop;
	}

	@Override
	@Transactional
	public void save(CoffeeShop coffeeShop) {
		coffeeShopDao.save(coffeeShop);
		
	}

	@Override
	@Transactional
	public void update(CoffeeShop coffeeShop) {
		coffeeShopDao.update(coffeeShop);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		coffeeShopDao.delete(id);
		
	}
}
