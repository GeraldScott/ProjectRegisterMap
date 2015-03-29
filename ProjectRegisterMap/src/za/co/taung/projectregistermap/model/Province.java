package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the provinces database table.
 * 
 */
@Entity
@Table(name="provinces")
@NamedQuery(name="Province.findAll", query="SELECT p FROM Province p")
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROVINCES_ID_GENERATOR", sequenceName="PROVINCES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROVINCES_ID_GENERATOR")
	private Integer id;

	private String code;

	private String name;

	//bi-directional many-to-one association to Place
	@OneToMany(mappedBy="provinceBean")
	private List<Place> places;

	public Province() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Place> getPlaces() {
		return this.places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public Place addPlace(Place place) {
		getPlaces().add(place);
		place.setProvinceBean(this);

		return place;
	}

	public Place removePlace(Place place) {
		getPlaces().remove(place);
		place.setProvinceBean(null);

		return place;
	}

}