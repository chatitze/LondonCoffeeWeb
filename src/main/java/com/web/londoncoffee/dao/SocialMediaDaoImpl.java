package com.web.londoncoffee.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.londoncoffee.model.SocialMedia;

/**
 * @author Chatitze Moumin
 *
 */

public class SocialMediaDaoImpl implements ISocialMediaDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SocialMediaDaoImpl(){
		super();
	}
	
	public SocialMediaDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public SocialMedia getSocialMedia(int id) {
		return (SocialMedia) sessionFactory.getCurrentSession()
				.createCriteria(SocialMedia.class)
				.add(Restrictions.idEq(id))
				.uniqueResult();
	}

	@Override
	public int saveSocialMedia(SocialMedia socialMedia) {
		sessionFactory.getCurrentSession().persist(socialMedia);

		return socialMedia.getId();
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		sessionFactory.getCurrentSession().update(socialMedia);
		
	}

	@Override
	public void deleteSocialMedia(int id) {
		SocialMedia socialMediaToDelete = new SocialMedia();
		socialMediaToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(socialMediaToDelete);
		
	}

}
