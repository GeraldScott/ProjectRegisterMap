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
	@SequenceGenerator(name="PROJECT_OUTPUTS_ID_GENERATOR", sequenceName="PROJECT_OUTPUTS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_OUTPUTS_ID_GENERATOR")
	private Integer id;

	private String description;

	//bi-directional many-to-one association to KeyPerformanceIndicator
	@ManyToOne
	@JoinColumn(name="key_performance_indicator")
	private KeyPerformanceIndicator keyPerformanceIndicatorBean;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project")
	private Project projectBean;

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

	public KeyPerformanceIndicator getKeyPerformanceIndicatorBean() {
		return this.keyPerformanceIndicatorBean;
	}

	public void setKeyPerformanceIndicatorBean(KeyPerformanceIndicator keyPerformanceIndicatorBean) {
		this.keyPerformanceIndicatorBean = keyPerformanceIndicatorBean;
	}

	public Project getProjectBean() {
		return this.projectBean;
	}

	public void setProjectBean(Project projectBean) {
		this.projectBean = projectBean;
	}

}