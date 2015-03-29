package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the project_types database table.
 * 
 */
@Entity
@Table(name="project_types")
@NamedQuery(name="ProjectType.findAll", query="SELECT p FROM ProjectType p")
public class ProjectType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECT_TYPES_ID_GENERATOR", sequenceName="PROJECT_TYPES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_TYPES_ID_GENERATOR")
	private Integer id;

	private String code;

	private String description;

	private String type;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="projectTypeBean")
	private List<Project> projects;

	public ProjectType() {
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

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setProjectTypeBean(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setProjectTypeBean(null);

		return project;
	}

}