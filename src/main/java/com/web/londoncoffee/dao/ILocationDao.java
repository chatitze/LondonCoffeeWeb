package com.web.londoncoffee.dao;

import com.web.londoncoffee.model.Location;

/**
 * @author Chatitze Moumin
 *
 */
public interface ILocationDao {

	public Location getLocation(int id);
	
	public int saveLocation(Location location);
	
	public void updateLocation(Location location);
	
	public void deleteLocation(int id);
}
