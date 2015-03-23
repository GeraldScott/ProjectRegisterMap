package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_outputs database table.
 * 
 */
@Entity
@Table(name="project_outputs")
@NamedQuery(name="ProjectOutput.findAll", query="SELECT p FROM ProjectOutput p")
public class ProjectOutput implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String description;

	//bi-directional many-to-one association to KeyPerformanceIndicator
	@ManyToOne
	@JoinColumn(name="key_performance_indicator")
	private KeyPerformanceIndicator keyPerformanceIndicator;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project")
	private Project project;

	public ProjectOutput() {
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

	public KeyPerformanceIndicator getKeyPerformanceIndicator() {
		return this.keyPerformanceIndicator;
	}

	public void setKeyPerformanceIndicator(KeyPerformanceIndicator keyPerformanceIndicator) {
		this.keyPerformanceIndicator = keyPerformanceIndicator;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}