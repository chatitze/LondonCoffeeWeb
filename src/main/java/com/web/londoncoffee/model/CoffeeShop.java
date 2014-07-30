package com.web.londoncoffee.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * @author Chatitze Moumin
 *
 */
@Entity
public class CoffeeShop implements Serializable{

	private static final long serialVersionUID = 3244651385490901521L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rating")
	private double rating;
	
	@Column(name = "webAddress")
	private String webAddress;
	
	@Column(name = "iconUrl")
	private String iconUrl;
	
	@Column(name = "priceLevel")
	private int priceLevel;

	@Column(name = "openningHours")
	private String openningHours;

	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "beans")
	private String beans;
	
	@Column(name = "machine")
	private String machine;
	
	@Column(name = "grinder")
	private String grinder;
	
	@OneToOne
	//@OneToOne(mappedBy="coffeeshop", cascade=CascadeType.ALL)
	private Location location;

	//@OneToOne
	//private SocialMedia socialMedia;
	
	//@OneToMany
	//private List<Review> review;
			
	public CoffeeShop() {
		super();
		
	}
	
	public CoffeeShop(String coffeeName, double rating, String webAddress, String iconUrl, int priceLevel,
			String openningHours, String phoneNumber, Location location) {
		this.name=coffeeName;
		this.rating=rating;
		this.webAddress=webAddress;
		this.iconUrl=iconUrl;
		this.priceLevel=priceLevel;
		this.openningHours=openningHours;
		this.phoneNumber=phoneNumber;
		this.location=location;
	}
	
	@Override
	public String toString() {
		return "CoffeeShop [name=" + name + ", rating=" + rating
				+ ", web address=" + webAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((webAddress == null) ? 0 : webAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeShop other = (CoffeeShop) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(rating) != Double
				.doubleToLongBits(other.rating))
			return false;
		if (webAddress == null) {
			if (other.webAddress != null)
				return false;
		} else if (!webAddress.equals(other.webAddress))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double d) {
		this.rating = d;
	}
	public String getWebAddress() {
		return webAddress;
	}
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public int getPriceLevel() {
		return priceLevel;
	}

	public void setPriceLevel(int priceLevel) {
		this.priceLevel = priceLevel;
	}

	public String getOpenningHours() {
		return openningHours;
	}

	public void setOpenningHours(String openningHours) {
		this.openningHours = openningHours;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}
