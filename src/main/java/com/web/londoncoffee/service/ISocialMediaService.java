package com.web.londoncoffee.service;

import com.web.londoncoffee.model.SocialMedia;

/**
 * @author Chatitze Moumin
 *
 */
public interface ISocialMediaService {

	public SocialMedia getSocialMedia(int id);
	
	public int saveSocialMedia(SocialMedia socialMedia);
	
	public void updateSocialMedia(SocialMedia socialMedia);
	
	public void deleteSocialMedia(int id);
}
