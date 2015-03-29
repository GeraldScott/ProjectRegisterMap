package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
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
	@SequenceGenerator(name="CALLS_ID_GENERATOR", sequenceName="CALLS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALLS_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="call_date")
	private Date callDate;

	@Column(name="call_number")
	private String callNumber;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="evaluation_date")
	private Date evaluationDate;

	private String title;

	//bi-directional many-to-one association to CallApplication
	@OneToMany(mappedBy="callBean")
	private List<CallApplication> callApplications;

	//bi-directional many-to-one association to KeyPerformanceIndicator
	@ManyToOne
	@JoinColumn(name="key_performance_indicator")
	private KeyPerformanceIndicator keyPerformanceIndicatorBean;

	//bi-directional many-to-one association to KeyResultArea
	@ManyToOne
	@JoinColumn(name="key_result_area")
	private KeyResultArea keyResultAreaBean;

	//bi-directional many-to-one association to Programme
	@ManyToOne
	@JoinColumn(name="programme")
	private Programme programmeBean;

	public Call() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCallDate() {
		return this.callDate;
	}

	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	public String getCallNumber() {
		return this.callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEvaluationDate() {
		return this.evaluationDate;
	}

	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

}