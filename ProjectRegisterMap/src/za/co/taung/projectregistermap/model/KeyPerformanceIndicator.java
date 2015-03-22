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
	private Integer id;

	private String actual;

	private String baseline;

	private String description;

	private String name;

	private String remarks;

	private String target;

	//bi-directional many-to-one association to Call
	@OneToMany(mappedBy="keyPerformanceIndicatorBean")
	private List<Call> calls;

	//bi-directional many-to-one association to KeyResultArea
	@ManyToOne
	@JoinColumn(name="key_result_area")
	private KeyResultArea keyResultAreaBean;

	//bi-directional many-to-one association to ProjectOutput
	@OneToMany(mappedBy="keyPerformanceIndicatorBean")
	private List<ProjectOutput> projectOutputs;

	public KeyPerformanceIndicator() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActual() {
		return this.actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public String getBaseline() {
		return this.baseline;
	}

	public void setBaseline(String baseline) {
		this.baseline = baseline;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
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

}