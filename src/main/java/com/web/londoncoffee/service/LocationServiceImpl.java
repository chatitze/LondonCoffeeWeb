package com.web.londoncoffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.londoncoffee.dao.ILocationDao;
import com.web.londoncoffee.model.Location;

/**
 * @author Chatitze Moumin
 *
 */
@Service
public class LocationServiceImpl implements ILocationService{

	@Autowired
	ILocationDao locationDao;
	
	public LocationServiceImpl(){
		super();
	}
	
	public LocationServiceImpl(ILocationDao locationDao){
		this.locationDao = locationDao;
	}
	
	@Override
	@Transactional(readOnly=true)
	public Location getLocation(int id) {
		Location location = locationDao.getLocation(id);
		return location;
	}

	@Override
	@Transactional
	public int saveLocation(Location location) {
		
		return locationDao.saveLocation(location);
	}

	@Override
	@Transactional
	public void updateLocation(Location location) {
		
		locationDao.updateLocation(location);
	}

	@Override
	@Transactional
	public void deleteLocation(int id) {
		
		locationDao.deleteLocation(id);
	}

}
