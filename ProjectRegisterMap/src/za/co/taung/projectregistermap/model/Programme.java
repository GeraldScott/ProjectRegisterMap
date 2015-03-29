package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the programmes database table.
 * 
 */
@Entity
@Table(name="programmes")
@NamedQuery(name="Programme.findAll", query="SELECT p FROM Programme p")
public class Programme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROGRAMMES_ID_GENERATOR", sequenceName="PROGRAMMES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROGRAMMES_ID_GENERATOR")
	private Integer id;

	private String code;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to Call
	@OneToMany(mappedBy="programmeBean")
	private List<Call> calls;

	//bi-directional many-to-one association to KeyPerformanceIndicator
	@OneToMany(mappedBy="programmeBean")
	private List<KeyPerformanceIndicator> keyPerformanceIndicators;

	//bi-directional many-to-one association to KeyResultArea
	@OneToMany(mappedBy="programmeBean")
	private List<KeyResultArea> keyResultAreas;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="funder")
	private Organisation organisation;

	//bi-directional many-to-one association to KpiMeasure
	@OneToMany(mappedBy="programmeBean")
	private List<KpiMeasure> kpiMeasures;

	public Programme() {
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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Call> getCalls() {
		return this.calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}

	public Call addCall(Call call) {
		getCalls().add(call);
		call.setProgrammeBean(this);

		return call;
	}

	public Call removeCall(Call call) {
		getCalls().remove(call);
		call.setProgrammeBean(null);

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
		keyPerformanceIndicator.setProgrammeBean(this);

		return keyPerformanceIndicator;
	}

	public KeyPerformanceIndicator removeKeyPerformanceIndicator(KeyPerformanceIndicator keyPerformanceIndicator) {
		getKeyPerformanceIndicators().remove(keyPerformanceIndicator);
		keyPerformanceIndicator.setProgrammeBean(null);

		return keyPerformanceIndicator;
	}

	public List<KeyResultArea> getKeyResultAreas() {
		return this.keyResultAreas;
	}

	public void setKeyResultAreas(List<KeyResultArea> keyResultAreas) {
		this.keyResultAreas = keyResultAreas;
	}

	public KeyResultArea addKeyResultArea(KeyResultArea keyResultArea) {
		getKeyResultAreas().add(keyResultArea);
		keyResultArea.setProgrammeBean(this);

		return keyResultArea;
	}

	public KeyResultArea removeKeyResultArea(KeyResultArea keyResultArea) {
		getKeyResultAreas().remove(keyResultArea);
		keyResultArea.setProgrammeBean(null);

		return keyResultArea;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public List<KpiMeasure> getKpiMeasures() {
		return this.kpiMeasures;
	}

	public void setKpiMeasures(List<KpiMeasure> kpiMeasures) {
		this.kpiMeasures = kpiMeasures;
	}

	public KpiMeasure addKpiMeasure(KpiMeasure kpiMeasure) {
		getKpiMeasures().add(kpiMeasure);
		kpiMeasure.setProgrammeBean(this);

		return kpiMeasure;
	}

	public KpiMeasure removeKpiMeasure(KpiMeasure kpiMeasure) {
		getKpiMeasures().remove(kpiMeasure);
		kpiMeasure.setProgrammeBean(null);

		return kpiMeasure;
	}

}