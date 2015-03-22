package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the addresses database table.
 * 
 */
@Entity
@Table(name="addresses")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="first_line")
	private String firstLine;

	@Column(name="second_line")
	private String secondLine;

	private String suburb;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="organisation")
	private Organisation organisationBean;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="place")
	private Place placeBean;

	//bi-directional many-to-one association to AddressType
	@ManyToOne
	@JoinColumn(name="address_type")
	private AddressType addressTypeBean;

	public Address() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstLine() {
		return this.firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return this.secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public String getSuburb() {
		return this.suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public Organisation getOrganisationBean() {
		return this.organisationBean;
	}

	public void setOrganisationBean(Organisation organisationBean) {
		this.organisationBean = organisationBean;
	}

	public Place getPlaceBean() {
		return this.placeBean;
	}

	public void setPlaceBean(Place placeBean) {
		this.placeBean = placeBean;
	}

	public AddressType getAddressTypeBean() {
		return this.addressTypeBean;
	}

	public void setAddressTypeBean(AddressType addressTypeBean) {
		this.addressTypeBean = addressTypeBean;
	}

}