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
	private CallApplicationStatus callApplicationStatusBean;

	//bi-directional many-to-one association to Call
	@ManyToOne
	@JoinColumn(name="call")
	private Call callBean;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="applicant")
	private Organisation organisation;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="place")
	private Place placeBean;

	//bi-directional many-to-one association to CallEvaluation
	@OneToMany(mappedBy="callApplicationBean")
	private List<CallEvaluation> callEvaluations;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="callApplicationBean")
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

	public CallApplicationStatus getCallApplicationStatusBean() {
		return this.callApplicationStatusBean;
	}

	public void setCallApplicationStatusBean(CallApplicationStatus callApplicationStatusBean) {
		this.callApplicationStatusBean = callApplicationStatusBean;
	}

	public Call getCallBean() {
		return this.callBean;
	}

	public void setCallBean(Call callBean) {
		this.callBean = callBean;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Place getPlaceBean() {
		return this.placeBean;
	}

	public void setPlaceBean(Place placeBean) {
		this.placeBean = placeBean;
	}

	public List<CallEvaluation> getCallEvaluations() {
		return this.callEvaluations;
	}

	public void setCallEvaluations(List<CallEvaluation> callEvaluations) {
		this.callEvaluations = callEvaluations;
	}

	public CallEvaluation addCallEvaluation(CallEvaluation callEvaluation) {
		getCallEvaluations().add(callEvaluation);
		callEvaluation.setCallApplicationBean(this);

		return callEvaluation;
	}

	public CallEvaluation removeCallEvaluation(CallEvaluation callEvaluation) {
		getCallEvaluations().remove(callEvaluation);
		callEvaluation.setCallApplicationBean(null);

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
		project.setCallApplicationBean(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setCallApplicationBean(null);

		return project;
	}

}