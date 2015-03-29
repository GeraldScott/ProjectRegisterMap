package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the project_statuses database table.
 * 
 */
@Entity
@Table(name="project_statuses")
@NamedQuery(name="ProjectStatus.findAll", query="SELECT p FROM ProjectStatus p")
public class ProjectStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECT_STATUSES_ID_GENERATOR", sequenceName="PROJECT_STATUSES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_STATUSES_ID_GENERATOR")
	private Integer id;

	private String description;

	private String status;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="projectStatusBean")
	private List<Project> projects;

	public ProjectStatus() {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setProjectStatusBean(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setProjectStatusBean(null);

		return project;
	}

}