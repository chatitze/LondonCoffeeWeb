package com.web.londoncoffee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



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
	
	@Column(name = "web")
	private String webAddress;
	
	
	public CoffeeShop() {
		super();
		
	}
	
	public CoffeeShop(String coffeeName, float rating, String webAddress) {
		this.name=coffeeName;
		this.rating=rating;
		this.webAddress=webAddress;
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
	
}
