package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calls database table.
 * 
 */
@Entity
@Table(name="calls")
@NamedQuery(name="Call.findAll", query="SELECT c FROM Call c")
public class Call implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="call_date")
	private Timestamp callDate;

	@Column(name="call_reference")
	private String callReference;

	private String description;

	@Column(name="evaluation_date")
	private Timestamp evaluationDate;

	private String name;

	//bi-directional many-to-one association to CallApplication
	@OneToMany(mappedBy="callBean")
	private List<CallApplication> callApplications;

	//bi-directional many-to-one association to KeyPerformanceIndicator
	@ManyToOne
	@JoinColumn(name="key_performance_indicator")
	private KeyPerformanceIndicator keyPerformanceIndicatorBean;

	public Call() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCallDate() {
		return this.callDate;
	}

	public void setCallDate(Timestamp callDate) {
		this.callDate = callDate;
	}

	public String getCallReference() {
		return this.callReference;
	}

	public void setCallReference(String callReference) {
		this.callReference = callReference;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getEvaluationDate() {
		return this.evaluationDate;
	}

	public void setEvaluationDate(Timestamp evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CallApplication> getCallApplications() {
		return this.callApplications;
	}

	public void setCallApplications(List<CallApplication> callApplications) {
		this.callApplications = callApplications;
	}

	public CallApplication addCallApplication(CallApplication callApplication) {
		getCallApplications().add(callApplication);
		callApplication.setCallBean(this);

		return callApplication;
	}

	public CallApplication removeCallApplication(CallApplication callApplication) {
		getCallApplications().remove(callApplication);
		callApplication.setCallBean(null);

		return callApplication;
	}

	public KeyPerformanceIndicator getKeyPerformanceIndicatorBean() {
		return this.keyPerformanceIndicatorBean;
	}

	public void setKeyPerformanceIndicatorBean(KeyPerformanceIndicator keyPerformanceIndicatorBean) {
		this.keyPerformanceIndicatorBean = keyPerformanceIndicatorBean;
	}

}