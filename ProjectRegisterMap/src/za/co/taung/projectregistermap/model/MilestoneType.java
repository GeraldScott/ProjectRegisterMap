package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the milestone_types database table.
 * 
 */
@Entity
@Table(name="milestone_types")
@NamedQuery(name="MilestoneType.findAll", query="SELECT m FROM MilestoneType m")
public class MilestoneType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MILESTONE_TYPES_ID_GENERATOR", sequenceName="MILESTONE_TYPES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MILESTONE_TYPES_ID_GENERATOR")
	private Integer id;

	private String code;

	private String description;

	private String type;

	//bi-directional many-to-one association to ProjectMilestone
	@OneToMany(mappedBy="milestoneTypeBean")
	private List<ProjectMilestone> projectMilestones;

	public MilestoneType() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ProjectMilestone> getProjectMilestones() {
		return this.projectMilestones;
	}

	public void setProjectMilestones(List<ProjectMilestone> projectMilestones) {
		this.projectMilestones = projectMilestones;
	}

	public ProjectMilestone addProjectMilestone(ProjectMilestone projectMilestone) {
		getProjectMilestones().add(projectMilestone);
		projectMilestone.setMilestoneTypeBean(this);

		return projectMilestone;
	}

	public ProjectMilestone removeProjectMilestone(ProjectMilestone projectMilestone) {
		getProjectMilestones().remove(projectMilestone);
		projectMilestone.setMilestoneTypeBean(null);

		return projectMilestone;
	}

}