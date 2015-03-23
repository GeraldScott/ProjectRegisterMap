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
	private Integer id;

	private String name;

	@Column(name="po_box_code")
	private String poBoxCode;

	@Column(name="street_code")
	private String streetCode;

	private String suburb;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="place")
	private List<Address> addresses;

	//bi-directional many-to-one association to GeoCode
	@ManyToOne
	@JoinColumn(name="geocode")
	private GeoCode geocode;

	//bi-directional many-to-one association to CallApplication
	@OneToMany(mappedBy="place")
	private List<CallApplication> callApplications;

	//bi-directional many-to-one association to Province
	@ManyToOne
	@JoinColumn(name="province")
	private Province province;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="place")
	private List<Project> projects;

	public Place() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setPlace(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setPlace(null);

		return address;
	}

	public GeoCode getGeocode() {
		return this.geocode;
	}

	public void setGeocode(GeoCode geocode) {
		this.geocode = geocode;
	}

	public List<CallApplication> getCallApplications() {
		return this.callApplications;
	}

	public void setCallApplications(List<CallApplication> callApplications) {
		this.callApplications = callApplications;
	}

	public CallApplication addCallApplication(CallApplication callApplication) {
		getCallApplications().add(callApplication);
		callApplication.setPlace(this);

		return callApplication;
	}

	public CallApplication removeCallApplication(CallApplication callApplication) {
		getCallApplications().remove(callApplication);
		callApplication.setPlace(null);

		return callApplication;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setPlace(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setPlace(null);

		return project;
	}

}