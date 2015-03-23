package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the persons database table.
 * 
 */
@Entity
@Table(name="persons")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="first_names")
	private String firstNames;

	@Column(name="id_no")
	private String idNo;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to CallEvaluation
	@OneToMany(mappedBy="person")
	private List<CallEvaluation> callEvaluations;

	//bi-directional many-to-one association to ContactDetail
	@OneToMany(mappedBy="person")
	private List<ContactDetail> contactDetails;

	//bi-directional many-to-one association to JobTitle
	@ManyToOne
	@JoinColumn(name="job_title")
	private JobTitle jobTitle;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="employer")
	private Organisation organisation;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="person")
	private List<Project> projects;

	public Person() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstNames() {
		return this.firstNames;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<CallEvaluation> getCallEvaluations() {
		return this.callEvaluations;
	}

	public void setCallEvaluations(List<CallEvaluation> callEvaluations) {
		this.callEvaluations = callEvaluations;
	}

	public CallEvaluation addCallEvaluation(CallEvaluation callEvaluation) {
		getCallEvaluations().add(callEvaluation);
		callEvaluation.setPerson(this);

		return callEvaluation;
	}

	public CallEvaluation removeCallEvaluation(CallEvaluation callEvaluation) {
		getCallEvaluations().remove(callEvaluation);
		callEvaluation.setPerson(null);

		return callEvaluation;
	}

	public List<ContactDetail> getContactDetails() {
		return this.contactDetails;
	}

	public void setContactDetails(List<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public ContactDetail addContactDetail(ContactDetail contactDetail) {
		getContactDetails().add(contactDetail);
		contactDetail.setPerson(this);

		return contactDetail;
	}

	public ContactDetail removeContactDetail(ContactDetail contactDetail) {
		getContactDetails().remove(contactDetail);
		contactDetail.setPerson(null);

		return contactDetail;
	}

	public JobTitle getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setPerson(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setPerson(null);

		return project;
	}

}