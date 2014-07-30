package com.web.londoncoffee.dao;

import com.web.londoncoffee.model.SocialMedia;

/**
 * @author Chatitze Moumin
 *
 */
public interface ISocialMediaDao {

	public SocialMedia getSocialMedia(int id);
	
	public int saveSocialMedia(SocialMedia socialMedia);
	
	public void updateSocialMedia(SocialMedia socialMedia);
	
	public void deleteSocialMedia(int id);
}
