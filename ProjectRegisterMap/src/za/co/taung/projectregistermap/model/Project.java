package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the projects database table.
 * 
 */
@Entity
@Table(name="projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String description;

	@Column(name="end_date")
	private Timestamp endDate;

	private String name;

	@Column(name="project_reference")
	private String projectReference;

	@Column(name="start_date")
	private Timestamp startDate;

	//bi-directional many-to-one association to ProjectExpense
	@OneToMany(mappedBy="projectBean")
	private List<ProjectExpense> projectExpenses;

	//bi-directional many-to-one association to ProjectMilestone
	@OneToMany(mappedBy="projectBean")
	private List<ProjectMilestone> projectMilestones;

	//bi-directional many-to-one association to ProjectOutput
	@OneToMany(mappedBy="projectBean")
	private List<ProjectOutput> projectOutputs;

	//bi-directional many-to-one association to CallApplication
	@ManyToOne
	@JoinColumn(name="call_application")
	private CallApplication callApplicationBean;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="partner")
	private Organisation organisation;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="project_officer")
	private Person person;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="place")
	private Place placeBean;

	//bi-directional many-to-one association to ProjectStatus
	@ManyToOne
	@JoinColumn(name="project_status")
	private ProjectStatus projectStatusBean;

	//bi-directional many-to-one association to ProjectType
	@ManyToOne
	@JoinColumn(name="project_type")
	private ProjectType projectTypeBean;

	public Project() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectReference() {
		return this.projectReference;
	}

	public void setProjectReference(String projectReference) {
		this.projectReference = projectReference;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public List<ProjectExpense> getProjectExpenses() {
		return this.projectExpenses;
	}

	public void setProjectExpenses(List<ProjectExpense> projectExpenses) {
		this.projectExpenses = projectExpenses;
	}

	public ProjectExpense addProjectExpens(ProjectExpense projectExpens) {
		getProjectExpenses().add(projectExpens);
		projectExpens.setProjectBean(this);

		return projectExpens;
	}

	public ProjectExpense removeProjectExpens(ProjectExpense projectExpens) {
		getProjectExpenses().remove(projectExpens);
		projectExpens.setProjectBean(null);

		return projectExpens;
	}

	public List<ProjectMilestone> getProjectMilestones() {
		return this.projectMilestones;
	}

	public void setProjectMilestones(List<ProjectMilestone> projectMilestones) {
		this.projectMilestones = projectMilestones;
	}

	public ProjectMilestone addProjectMilestone(ProjectMilestone projectMilestone) {
		getProjectMilestones().add(projectMilestone);
		projectMilestone.setProjectBean(this);

		return projectMilestone;
	}

	public ProjectMilestone removeProjectMilestone(ProjectMilestone projectMilestone) {
		getProjectMilestones().remove(projectMilestone);
		projectMilestone.setProjectBean(null);

		return projectMilestone;
	}

	public List<ProjectOutput> getProjectOutputs() {
		return this.projectOutputs;
	}

	public void setProjectOutputs(List<ProjectOutput> projectOutputs) {
		this.projectOutputs = projectOutputs;
	}

	public ProjectOutput addProjectOutput(ProjectOutput projectOutput) {
		getProjectOutputs().add(projectOutput);
		projectOutput.setProjectBean(this);

		return projectOutput;
	}

	public ProjectOutput removeProjectOutput(ProjectOutput projectOutput) {
		getProjectOutputs().remove(projectOutput);
		projectOutput.setProjectBean(null);

		return projectOutput;
	}

	public CallApplication getCallApplicationBean() {
		return this.callApplicationBean;
	}

	public void setCallApplicationBean(CallApplication callApplicationBean) {
		this.callApplicationBean = callApplicationBean;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Place getPlaceBean() {
		return this.placeBean;
	}

	public void setPlaceBean(Place placeBean) {
		this.placeBean = placeBean;
	}

	public ProjectStatus getProjectStatusBean() {
		return this.projectStatusBean;
	}

	public void setProjectStatusBean(ProjectStatus projectStatusBean) {
		this.projectStatusBean = projectStatusBean;
	}

	public ProjectType getProjectTypeBean() {
		return this.projectTypeBean;
	}

	public void setProjectTypeBean(ProjectType projectTypeBean) {
		this.projectTypeBean = projectTypeBean;
	}

}