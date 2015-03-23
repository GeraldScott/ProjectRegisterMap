package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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
	private Integer id;

	@Column(name="milestone_date")
	private Timestamp milestoneDate;

	//bi-directional many-to-one association to MilestoneType
	@ManyToOne
	@JoinColumn(name="milestone_type")
	private MilestoneType milestoneType;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project")
	private Project project;

	public ProjectMilestone() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getMilestoneDate() {
		return this.milestoneDate;
	}

	public void setMilestoneDate(Timestamp milestoneDate) {
		this.milestoneDate = milestoneDate;
	}

	public MilestoneType getMilestoneType() {
		return this.milestoneType;
	}

	public void setMilestoneType(MilestoneType milestoneType) {
		this.milestoneType = milestoneType;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}