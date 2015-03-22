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
	private MilestoneType milestoneTypeBean;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project")
	private Project projectBean;

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

}