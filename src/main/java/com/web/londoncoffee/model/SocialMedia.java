package com.web.londoncoffee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author Chatitze Moumin
 *
 */

@Entity
public class SocialMedia implements Serializable{

	private static final long serialVersionUID = 6787273105233028182L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "facebook")
	private String facebook;
	
	@Column(name = "twitter")
	private String twitter;
	
	@Column(name = "instagram")
	private String instagram;
	
	@Column(name = "pinterest")
	private String pinterest;
	
	@Column(name = "timeout")
	private String timeout;

	@OneToOne
    @PrimaryKeyJoinColumn
    private CoffeeShop coffeeShop;
		
	public SocialMedia(){
		super();
	}
	
	
	public SocialMedia(String facebook, String twitter, String instagram,
			String pinterest, String timeout, CoffeeShop coffeeShop) {
		super();
		this.facebook = facebook;
		this.twitter = twitter;
		this.instagram = instagram;
		this.pinterest = pinterest;
		this.timeout = timeout;
		this.coffeeShop = coffeeShop;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getPinterest() {
		return pinterest;
	}
	public void setPinterest(String pinterest) {
		this.pinterest = pinterest;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}


	@Override
	public String toString() {
		return "SocialMedia [facebook=" + facebook + ", twitter=" + twitter
				+ ", timeOut=" + timeout + "]";
	}
	
}
