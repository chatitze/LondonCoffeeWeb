package com.web.londoncoffee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

/**
 * @author Chatitze Moumin
 *
 */

@Entity
public class Location implements Serializable{

	private static final long serialVersionUID = -1405331969512796452L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "latitude")
	private double lat;

	@Column(name = "longitude")
	private double lng;
	
	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "postalCode")
	private String postalCode;

	@Column(name = "country")
	private String country;

	@Column(name = "cc")
	private String cc;

	@Column(name = "crossStreet")
	private String crossStreet;
	
	@Transient
	private double distance;

	@OneToOne
    @PrimaryKeyJoinColumn
    private CoffeeShop coffeeShop;

	public Location() {
        super();
    }
    
	public Location(double lat, double lng, String address, String city,
			String state, String postalCode, String country, String cc,
			String crossStreet, CoffeeShop coffeeShop) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.cc = cc;
		this.crossStreet = crossStreet;
		this.coffeeShop = coffeeShop;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCrossStreet() {
		return crossStreet;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public double getDistance() {
		return distance;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setCrossStreet(String crossStreet) {
		this.crossStreet = crossStreet;
	}	
	
	public CoffeeShop getCoffeeShop() {
		return coffeeShop;
	}
	public void setCoffeeShop(CoffeeShop coffeeShop) {
		this.coffeeShop = coffeeShop;
	}

    // return distance between this location and that location
    // measured in statute miles
    public double distanceTo(Location that) {
        double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
        double lat1 = Math.toRadians(this.lat);
        double lon1 = Math.toRadians(this.lng);
        double lat2 = Math.toRadians(that.lat);
        double lon2 = Math.toRadians(that.lng);

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                               + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // each degree on a great circle of Earth is 60 nautical miles
        double nauticalMiles = 60 * Math.toDegrees(angle);
        double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
        return statuteMiles;
    }

    // return string representation of this point
    public String toString() {
        return ":" + " (" + lat + ", " + lng + ")";
    }
}
