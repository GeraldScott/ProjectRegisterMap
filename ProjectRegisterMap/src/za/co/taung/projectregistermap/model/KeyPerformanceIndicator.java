package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the key_performance_indicators database table.
 * 
 */
@Entity
@Table(name="key_performance_indicators")
@NamedQuery(name="KeyPerformanceIndicator.findAll", query="SELECT k FROM KeyPerformanceIndicator k")
public class KeyPerformanceIndicator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="KEY_PERFORMANCE_INDICATORS_ID_GENERATOR", sequenceName="KEY_PERFORMANCE_INDICATORS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KEY_PERFORMANCE_INDICATORS_ID_GENERATOR")
	private Integer id;

	private String code;

	private String description;

	//bi-directional many-to-one association to Call
	@OneToMany(mappedBy="keyPerformanceIndicatorBean")
	private List<Call> calls;

	//bi-directional many-to-one association to KeyResultArea
	@ManyToOne
	@JoinColumn(name="key_result_area")
	private KeyResultArea keyResultAreaBean;

	//bi-directional many-to-one association to Programme
	@ManyToOne
	@JoinColumn(name="programme")
	private Programme programmeBean;

	//bi-directional many-to-one association to ProjectOutput
	@OneToMany(mappedBy="keyPerformanceIndicatorBean")
	private List<ProjectOutput> projectOutputs;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="keyPerformanceIndicatorBean")
	private List<Project> projects;

	//bi-directional many-to-one association to KpiMeasure
	@OneToMany(mappedBy="keyPerformanceIndicatorBean")
	private List<KpiMeasure> kpiMeasures;

	public KeyPerformanceIndicator() {
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

	public List<Call> getCalls() {
		return this.calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}

	public Call addCall(Call call) {
		getCalls().add(call);
		call.setKeyPerformanceIndicatorBean(this);

		return call;
	}

	public Call removeCall(Call call) {
		getCalls().remove(call);
		call.setKeyPerformanceIndicatorBean(null);

		return call;
	}

	public KeyResultArea getKeyResultAreaBean() {
		return this.keyResultAreaBean;
	}

	public void setKeyResultAreaBean(KeyResultArea keyResultAreaBean) {
		this.keyResultAreaBean = keyResultAreaBean;
	}

	public Programme getProgrammeBean() {
		return this.programmeBean;
	}

	public void setProgrammeBean(Programme programmeBean) {
		this.programmeBean = programmeBean;
	}

	public List<ProjectOutput> getProjectOutputs() {
		return this.projectOutputs;
	}

	public void setProjectOutputs(List<ProjectOutput> projectOutputs) {
		this.projectOutputs = projectOutputs;
	}

	public ProjectOutput addProjectOutput(ProjectOutput projectOutput) {
		getProjectOutputs().add(projectOutput);
		projectOutput.setKeyPerformanceIndicatorBean(this);

		return projectOutput;
	}

	public ProjectOutput removeProjectOutput(ProjectOutput projectOutput) {
		getProjectOutputs().remove(projectOutput);
		projectOutput.setKeyPerformanceIndicatorBean(null);

		return projectOutput;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setKeyPerformanceIndicatorBean(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setKeyPerformanceIndicatorBean(null);

		return project;
	}

	public List<KpiMeasure> getKpiMeasures() {
		return this.kpiMeasures;
	}

	public void setKpiMeasures(List<KpiMeasure> kpiMeasures) {
		this.kpiMeasures = kpiMeasures;
	}

	public KpiMeasure addKpiMeasure(KpiMeasure kpiMeasure) {
		getKpiMeasures().add(kpiMeasure);
		kpiMeasure.setKeyPerformanceIndicatorBean(this);

		return kpiMeasure;
	}

	public KpiMeasure removeKpiMeasure(KpiMeasure kpiMeasure) {
		getKpiMeasures().remove(kpiMeasure);
		kpiMeasure.setKeyPerformanceIndicatorBean(null);

		return kpiMeasure;
	}

}