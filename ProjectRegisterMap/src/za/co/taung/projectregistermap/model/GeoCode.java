package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the geocodes database table.
 * 
 */
@Entity
@Table(name="geocodes")
@NamedQuery(name="GeoCode.findAll", query="SELECT g FROM GeoCode g")
public class GeoCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private double latitude;

	private double longitude;

	private String name;

	@Column(name="street_code")
	private String streetCode;

	//bi-directional many-to-one association to Place
	@OneToMany(mappedBy="geocodeBean")
	private List<Place> places;

	public GeoCode() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetCode() {
		return this.streetCode;
	}

	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}

	public List<Place> getPlaces() {
		return this.places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public Place addPlace(Place place) {
		getPlaces().add(place);
		place.setGeocodeBean(this);

		return place;
	}

	public Place removePlace(Place place) {
		getPlaces().remove(place);
		place.setGeocodeBean(null);

		return place;
	}

}