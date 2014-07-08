package com.web.londoncoffee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.londoncoffee.model.CoffeeShop;
/**
 * @author Chatitze Moumin
 *
 */
@Repository
public class CoffeeShopDaoImpl implements ICoffeeShopDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public CoffeeShopDaoImpl(){
		super();
	}
	
	public CoffeeShopDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CoffeeShop> getCoffeeShopList(){
		
		@SuppressWarnings("unchecked")
		//List<CoffeeShop> list = sessionFactory.getCurrentSession().createQuery("from lovecoffee.coffeeshop").list();
		/*List<CoffeeShop> list = (List<CoffeeShop>) sessionFactory.getCurrentSession()
								.createCriteria(CoffeeShop.class)
								.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		*/
		//List<CoffeeShop> list = sessionFactory.getCurrentSession().createQuery("from CoffeeShop").list();
		
		List<CoffeeShop> list =  sessionFactory.getCurrentSession().createCriteria(CoffeeShop.class).list();
		return  list;
	}

	@Override
	public CoffeeShop getCoffeeShop(int id) {
		return (CoffeeShop) sessionFactory.getCurrentSession()
				.createCriteria(CoffeeShop.class)
				.add(Restrictions.idEq(id))
				.uniqueResult();
	}

	@Override
	public int save(CoffeeShop coffeeShop) {
		sessionFactory.getCurrentSession().persist(coffeeShop);

		return coffeeShop.getId();
	}

	@Override
	public void update(CoffeeShop coffeeShop) {
		sessionFactory.getCurrentSession().update(coffeeShop);
		
	}

	@Override
	public void delete(int id) {
		CoffeeShop shopToDelete = new CoffeeShop();
		shopToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(shopToDelete);		
	}
	
	
}
