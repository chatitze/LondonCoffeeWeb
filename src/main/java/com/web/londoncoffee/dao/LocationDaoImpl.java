package com.web.londoncoffee.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.londoncoffee.model.Location;

/**
 * @author Chatitze Moumin
 *
 */
@Repository
public class LocationDaoImpl implements ILocationDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public LocationDaoImpl(){
		super();
	}
	
	public LocationDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Location getLocation(int id) {
		return (Location) sessionFactory.getCurrentSession()
				.createCriteria(Location.class)
				.add(Restrictions.idEq(id))
				.uniqueResult();
	}

	@Override
	public int saveLocation(Location location) {
		sessionFactory.getCurrentSession().persist(location);

		return location.getId();
	}

	@Override
	public void updateLocation(Location location) {
		sessionFactory.getCurrentSession().update(location);
		
	}

	@Override
	public void deleteLocation(int id) {
		Location locationToDelete = new Location();
		locationToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(locationToDelete);
		
	}

}
