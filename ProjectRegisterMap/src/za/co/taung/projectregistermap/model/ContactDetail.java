package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contact_details database table.
 * 
 */
@Entity
@Table(name="contact_details")
@NamedQuery(name="ContactDetail.findAll", query="SELECT c FROM ContactDetail c")
public class ContactDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTACT_DETAILS_ID_GENERATOR", sequenceName="CONTACT_DETAILS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACT_DETAILS_ID_GENERATOR")
	private Integer id;

	@Column(name="cell_phone")
	private String cellPhone;

	@Column(name="email_address")
	private String emailAddress;

	@Column(name="fax_no")
	private String faxNo;

	@Column(name="work_phone")
	private String workPhone;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="organisation")
	private Organisation organisationBean;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person")
	private Person personBean;

	public ContactDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFaxNo() {
		return this.faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public Organisation getOrganisationBean() {
		return this.organisationBean;
	}

	public void setOrganisationBean(Organisation organisationBean) {
		this.organisationBean = organisationBean;
	}

	public Person getPersonBean() {
		return this.personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

}