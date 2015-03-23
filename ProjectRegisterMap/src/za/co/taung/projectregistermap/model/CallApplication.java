package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the call_applications database table.
 * 
 */
@Entity
@Table(name="call_applications")
@NamedQuery(name="CallApplication.findAll", query="SELECT c FROM CallApplication c")
public class CallApplication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private double amount;

	@Column(name="application_no")
	private Integer applicationNo;

	private String comments;

	private Integer score;

	//bi-directional many-to-one association to CallApplicationStatus
	@ManyToOne
	@JoinColumn(name="call_application_status")
	private CallApplicationStatus callApplicationStatus;

	//bi-directional many-to-one association to Call
	@ManyToOne
	@JoinColumn(name="call")
	private Call call;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="applicant")
	private Organisation organisation;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="place")
	private Place place;

	//bi-directional many-to-one association to CallEvaluation
	@OneToMany(mappedBy="callApplication")
	private List<CallEvaluation> callEvaluations;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="callApplication")
	private List<Project> projects;

	public CallApplication() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getApplicationNo() {
		return this.applicationNo;
	}

	public void setApplicationNo(Integer applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public CallApplicationStatus getCallApplicationStatus() {
		return this.callApplicationStatus;
	}

	public void setCallApplicationStatus(CallApplicationStatus callApplicationStatus) {
		this.callApplicationStatus = callApplicationStatus;
	}

	public Call getCall() {
		return this.call;
	}

	public void setCall(Call call) {
		this.call = call;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<CallEvaluation> getCallEvaluations() {
		return this.callEvaluations;
	}

	public void setCallEvaluations(List<CallEvaluation> callEvaluations) {
		this.callEvaluations = callEvaluations;
	}

	public CallEvaluation addCallEvaluation(CallEvaluation callEvaluation) {
		getCallEvaluations().add(callEvaluation);
		callEvaluation.setCallApplication(this);

		return callEvaluation;
	}

	public CallEvaluation removeCallEvaluation(CallEvaluation callEvaluation) {
		getCallEvaluations().remove(callEvaluation);
		callEvaluation.setCallApplication(null);

		return callEvaluation;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setCallApplication(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setCallApplication(null);

		return project;
	}

}