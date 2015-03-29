package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the places database table.
 * 
 */
@Entity
@Table(name="places")
@NamedQuery(name="Place.findAll", query="SELECT p FROM Place p")
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PLACES_ID_GENERATOR", sequenceName="PLACES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PLACES_ID_GENERATOR")
	private Integer id;

	@Column(name="po_box_code")
	private String poBoxCode;

	@Column(name="street_code")
	private String streetCode;

	private String suburb;

	private String town;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="placeBean")
	private List<Address> addresses;

	//bi-directional many-to-one association to CallApplication
	@OneToMany(mappedBy="placeBean")
	private List<CallApplication> callApplications;

	//bi-directional many-to-one association to GeoCode
	@ManyToOne
	@JoinColumn(name="geocode")
	private GeoCode geocodeBean;

	//bi-directional many-to-one association to Province
	@ManyToOne
	@JoinColumn(name="province")
	private Province provinceBean;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="placeBean")
	private List<Project> projects;

	public Place() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPoBoxCode() {
		return this.poBoxCode;
	}

	public void setPoBoxCode(String poBoxCode) {
		this.poBoxCode = poBoxCode;
	}

	public String getStreetCode() {
		return this.streetCode;
	}

	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}

	public String getSuburb() {
		return this.suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setPlaceBean(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setPlaceBean(null);

		return address;
	}

	public List<CallApplication> getCallApplications() {
		return this.callApplications;
	}

	public void setCallApplications(List<CallApplication> callApplications) {
		this.callApplications = callApplications;
	}

	public CallApplication addCallApplication(CallApplication callApplication) {
		getCallApplications().add(callApplication);
		callApplication.setPlaceBean(this);

		return callApplication;
	}

	public CallApplication removeCallApplication(CallApplication callApplication) {
		getCallApplications().remove(callApplication);
		callApplication.setPlaceBean(null);

		return callApplication;
	}

	public GeoCode getGeocodeBean() {
		return this.geocodeBean;
	}

	public void setGeocodeBean(GeoCode geocodeBean) {
		this.geocodeBean = geocodeBean;
	}

	public Province getProvinceBean() {
		return this.provinceBean;
	}

	public void setProvinceBean(Province provinceBean) {
		this.provinceBean = provinceBean;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setPlaceBean(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setPlaceBean(null);

		return project;
	}

}