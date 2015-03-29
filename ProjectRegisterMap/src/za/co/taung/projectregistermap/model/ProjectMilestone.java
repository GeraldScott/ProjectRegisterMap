package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the project_milestones database table.
 * 
 */
@Entity
@Table(name="project_milestones")
@NamedQuery(name="ProjectMilestone.findAll", query="SELECT p FROM ProjectMilestone p")
public class ProjectMilestone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECT_MILESTONES_ID_GENERATOR", sequenceName="PROJECT_MILESTONES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_MILESTONES_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="milestone_date")
	private Date milestoneDate;

	//bi-directional many-to-one association to MilestoneType
	@ManyToOne
	@JoinColumn(name="milestone_type")
	private MilestoneType milestoneTypeBean;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project")
	private Project projectBean;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="projectMilestone")
	private List<Project> projects;

	public ProjectMilestone() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMilestoneDate() {
		return this.milestoneDate;
	}

	public void setMilestoneDate(Date milestoneDate) {
		this.milestoneDate = milestoneDate;
	}

	public MilestoneType getMilestoneTypeBean() {
		return this.milestoneTypeBean;
	}

	public void setMilestoneTypeBean(MilestoneType milestoneTypeBean) {
		this.milestoneTypeBean = milestoneTypeBean;
	}

	public Project getProjectBean() {
		return this.projectBean;
	}

	public void setProjectBean(Project projectBean) {
		this.projectBean = projectBean;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setProjectMilestone(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setProjectMilestone(null);

		return project;
	}

}