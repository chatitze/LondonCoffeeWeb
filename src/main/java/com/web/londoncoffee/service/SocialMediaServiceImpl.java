package com.web.londoncoffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.londoncoffee.dao.ISocialMediaDao;
import com.web.londoncoffee.model.SocialMedia;

/**
 * @author Chatitze Moumin
 *
 */
@Service
public class SocialMediaServiceImpl implements ISocialMediaService{

	@Autowired
	ISocialMediaDao socialMediaDao;
	
	public SocialMediaServiceImpl(){
		super();
	}
	
	public SocialMediaServiceImpl(ISocialMediaDao socialMediaDao){
		this.socialMediaDao = socialMediaDao;
	}
	
	@Override
	@Transactional(readOnly=true)
	public SocialMedia getSocialMedia(int id) {
		SocialMedia socialMedia = socialMediaDao.getSocialMedia(id);
		return socialMedia;
	}

	@Override
	@Transactional
	public int saveSocialMedia(SocialMedia socialMedia) {
		
		return socialMediaDao.saveSocialMedia(socialMedia);
	}

	@Override
	@Transactional
	public void updateSocialMedia(SocialMedia socialMedia) {
		
		socialMediaDao.updateSocialMedia(socialMedia);
	}

	@Override
	@Transactional
	public void deleteSocialMedia(int id) {
		
		socialMediaDao.deleteSocialMedia(id);
	}

}
