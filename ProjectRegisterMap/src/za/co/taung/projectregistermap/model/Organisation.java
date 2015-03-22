package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organisations database table.
 * 
 */
@Entity
@Table(name="organisations")
@NamedQuery(name="Organisation.findAll", query="SELECT o FROM Organisation o")
public class Organisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String code;

	private String name;

	@Column(name="npo_no")
	private String npoNo;

	@Column(name="vat_no")
	private String vatNo;

	@Column(name="web_site")
	private String webSite;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="organisationBean")
	private List<Address> addresses;

	//bi-directional many-to-one association to OrganisationType
	@ManyToOne
	@JoinColumn(name="organisation_type")
	private OrganisationType organisationTypeBean;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="auditor")
	private Organisation organisation1;

	//bi-directional many-to-one association to Organisation
	@OneToMany(mappedBy="organisation1")
	private List<Organisation> organisations1;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="reference")
	private Organisation organisation2;

	//bi-directional many-to-one association to Organisation
	@OneToMany(mappedBy="organisation2")
	private List<Organisation> organisations2;

	//bi-directional many-to-one association to BankAccount
	@OneToMany(mappedBy="organisation1")
	private List<BankAccount> bankAccounts1;

	//bi-directional many-to-one association to BankAccount
	@OneToMany(mappedBy="organisation2")
	private List<BankAccount> bankAccounts2;

	//bi-directional many-to-one association to CallApplication
	@OneToMany(mappedBy="organisation")
	private List<CallApplication> callApplications;

	//bi-directional many-to-one association to ContactDetail
	@OneToMany(mappedBy="organisationBean")
	private List<ContactDetail> contactDetails;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="organisation")
	private List<Person> persons;

	//bi-directional many-to-one association to Programme
	@OneToMany(mappedBy="organisation")
	private List<Programme> programmes;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="organisation")
	private List<Project> projects;

	public Organisation() {
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

	public String getNpoNo() {
		return this.npoNo;
	}

	public void setNpoNo(String npoNo) {
		this.npoNo = npoNo;
	}

	public String getVatNo() {
		return this.vatNo;
	}

	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setOrganisationBean(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setOrganisationBean(null);

		return address;
	}

	public OrganisationType getOrganisationTypeBean() {
		return this.organisationTypeBean;
	}

	public void setOrganisationTypeBean(OrganisationType organisationTypeBean) {
		this.organisationTypeBean = organisationTypeBean;
	}

	public Organisation getOrganisation1() {
		return this.organisation1;
	}

	public void setOrganisation1(Organisation organisation1) {
		this.organisation1 = organisation1;
	}

	public List<Organisation> getOrganisations1() {
		return this.organisations1;
	}

	public void setOrganisations1(List<Organisation> organisations1) {
		this.organisations1 = organisations1;
	}

	public Organisation addOrganisations1(Organisation organisations1) {
		getOrganisations1().add(organisations1);
		organisations1.setOrganisation1(this);

		return organisations1;
	}

	public Organisation removeOrganisations1(Organisation organisations1) {
		getOrganisations1().remove(organisations1);
		organisations1.setOrganisation1(null);

		return organisations1;
	}

	public Organisation getOrganisation2() {
		return this.organisation2;
	}

	public void setOrganisation2(Organisation organisation2) {
		this.organisation2 = organisation2;
	}

	public List<Organisation> getOrganisations2() {
		return this.organisations2;
	}

	public void setOrganisations2(List<Organisation> organisations2) {
		this.organisations2 = organisations2;
	}

	public Organisation addOrganisations2(Organisation organisations2) {
		getOrganisations2().add(organisations2);
		organisations2.setOrganisation2(this);

		return organisations2;
	}

	public Organisation removeOrganisations2(Organisation organisations2) {
		getOrganisations2().remove(organisations2);
		organisations2.setOrganisation2(null);

		return organisations2;
	}

	public List<BankAccount> getBankAccounts1() {
		return this.bankAccounts1;
	}

	public void setBankAccounts1(List<BankAccount> bankAccounts1) {
		this.bankAccounts1 = bankAccounts1;
	}

	public BankAccount addBankAccounts1(BankAccount bankAccounts1) {
		getBankAccounts1().add(bankAccounts1);
		bankAccounts1.setOrganisation1(this);

		return bankAccounts1;
	}

	public BankAccount removeBankAccounts1(BankAccount bankAccounts1) {
		getBankAccounts1().remove(bankAccounts1);
		bankAccounts1.setOrganisation1(null);

		return bankAccounts1;
	}

	public List<BankAccount> getBankAccounts2() {
		return this.bankAccounts2;
	}

	public void setBankAccounts2(List<BankAccount> bankAccounts2) {
		this.bankAccounts2 = bankAccounts2;
	}

	public BankAccount addBankAccounts2(BankAccount bankAccounts2) {
		getBankAccounts2().add(bankAccounts2);
		bankAccounts2.setOrganisation2(this);

		return bankAccounts2;
	}

	public BankAccount removeBankAccounts2(BankAccount bankAccounts2) {
		getBankAccounts2().remove(bankAccounts2);
		bankAccounts2.setOrganisation2(null);

		return bankAccounts2;
	}

	public List<CallApplication> getCallApplications() {
		return this.callApplications;
	}

	public void setCallApplications(List<CallApplication> callApplications) {
		this.callApplications = callApplications;
	}

	public CallApplication addCallApplication(CallApplication callApplication) {
		getCallApplications().add(callApplication);
		callApplication.setOrganisation(this);

		return callApplication;
	}

	public CallApplication removeCallApplication(CallApplication callApplication) {
		getCallApplications().remove(callApplication);
		callApplication.setOrganisation(null);

		return callApplication;
	}

	public List<ContactDetail> getContactDetails() {
		return this.contactDetails;
	}

	public void setContactDetails(List<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public ContactDetail addContactDetail(ContactDetail contactDetail) {
		getContactDetails().add(contactDetail);
		contactDetail.setOrganisationBean(this);

		return contactDetail;
	}

	public ContactDetail removeContactDetail(ContactDetail contactDetail) {
		getContactDetails().remove(contactDetail);
		contactDetail.setOrganisationBean(null);

		return contactDetail;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setOrganisation(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setOrganisation(null);

		return person;
	}

	public List<Programme> getProgrammes() {
		return this.programmes;
	}

	public void setProgrammes(List<Programme> programmes) {
		this.programmes = programmes;
	}

	public Programme addProgramme(Programme programme) {
		getProgrammes().add(programme);
		programme.setOrganisation(this);

		return programme;
	}

	public Programme removeProgramme(Programme programme) {
		getProgrammes().remove(programme);
		programme.setOrganisation(null);

		return programme;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setOrganisation(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setOrganisation(null);

		return project;
	}

}