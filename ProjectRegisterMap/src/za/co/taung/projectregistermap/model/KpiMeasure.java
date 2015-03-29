package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kpi_measures database table.
 * 
 */
@Entity
@Table(name="kpi_measures")
@NamedQuery(name="KpiMeasure.findAll", query="SELECT k FROM KpiMeasure k")
public class KpiMeasure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="KPI_MEASURES_ID_GENERATOR", sequenceName="KPI_MEASURES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KPI_MEASURES_ID_GENERATOR")
	private Integer id;

	private String actual;

	private String baseline;

	private String remarks;

	@Column(name="reporting_period")
	private String reportingPeriod;

	private String status;

	private String target;

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

	public KpiMeasure() {
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

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReportingPeriod() {
		return this.reportingPeriod;
	}

	public void setReportingPeriod(String reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
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