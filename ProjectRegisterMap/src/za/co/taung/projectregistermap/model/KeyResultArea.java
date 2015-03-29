package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the key_result_areas database table.
 * 
 */
@Entity
@Table(name="key_result_areas")
@NamedQuery(name="KeyResultArea.findAll", query="SELECT k FROM KeyResultArea k")
public class KeyResultArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="KEY_RESULT_AREAS_ID_GENERATOR", sequenceName="KEY_RESULT_AREAS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KEY_RESULT_AREAS_ID_GENERATOR")
	private Integer id;

	private String code;

	private String description;

	//bi-directional many-to-one association to Call
	@OneToMany(mappedBy="keyResultAreaBean")
	private List<Call> calls;

	//bi-directional many-to-one association to KeyPerformanceIndicator
	@OneToMany(mappedBy="keyResultAreaBean")
	private List<KeyPerformanceIndicator> keyPerformanceIndicators;

	//bi-directional many-to-one association to Programme
	@ManyToOne
	@JoinColumn(name="programme")
	private Programme programmeBean;

	//bi-directional many-to-one association to KpiMeasure
	@OneToMany(mappedBy="keyResultAreaBean")
	private List<KpiMeasure> kpiMeasures;

	public KeyResultArea() {
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
		call.setKeyResultAreaBean(this);

		return call;
	}

	public Call removeCall(Call call) {
		getCalls().remove(call);
		call.setKeyResultAreaBean(null);

		return call;
	}

	public List<KeyPerformanceIndicator> getKeyPerformanceIndicators() {
		return this.keyPerformanceIndicators;
	}

	public void setKeyPerformanceIndicators(List<KeyPerformanceIndicator> keyPerformanceIndicators) {
		this.keyPerformanceIndicators = keyPerformanceIndicators;
	}

	public KeyPerformanceIndicator addKeyPerformanceIndicator(KeyPerformanceIndicator keyPerformanceIndicator) {
		getKeyPerformanceIndicators().add(keyPerformanceIndicator);
		keyPerformanceIndicator.setKeyResultAreaBean(this);

		return keyPerformanceIndicator;
	}

	public KeyPerformanceIndicator removeKeyPerformanceIndicator(KeyPerformanceIndicator keyPerformanceIndicator) {
		getKeyPerformanceIndicators().remove(keyPerformanceIndicator);
		keyPerformanceIndicator.setKeyResultAreaBean(null);

		return keyPerformanceIndicator;
	}

	public Programme getProgrammeBean() {
		return this.programmeBean;
	}

	public void setProgrammeBean(Programme programmeBean) {
		this.programmeBean = programmeBean;
	}

	public List<KpiMeasure> getKpiMeasures() {
		return this.kpiMeasures;
	}

	public void setKpiMeasures(List<KpiMeasure> kpiMeasures) {
		this.kpiMeasures = kpiMeasures;
	}

	public KpiMeasure addKpiMeasure(KpiMeasure kpiMeasure) {
		getKpiMeasures().add(kpiMeasure);
		kpiMeasure.setKeyResultAreaBean(this);

		return kpiMeasure;
	}

	public KpiMeasure removeKpiMeasure(KpiMeasure kpiMeasure) {
		getKpiMeasures().remove(kpiMeasure);
		kpiMeasure.setKeyResultAreaBean(null);

		return kpiMeasure;
	}

}