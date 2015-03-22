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
	private Integer id;

	private String description;

	private String name;

	//bi-directional many-to-one association to KeyPerformanceIndicator
	@OneToMany(mappedBy="keyResultAreaBean")
	private List<KeyPerformanceIndicator> keyPerformanceIndicators;

	//bi-directional many-to-one association to Programme
	@ManyToOne
	@JoinColumn(name="programme")
	private Programme programmeBean;

	public KeyResultArea() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

}