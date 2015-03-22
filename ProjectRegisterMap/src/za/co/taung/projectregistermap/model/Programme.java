package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
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
	private Integer id;

	private String abbreviation;

	private String description;

	@Column(name="end_date")
	private Timestamp endDate;

	private String name;

	@Column(name="start_date")
	private Timestamp startDate;

	//bi-directional many-to-one association to KeyResultArea
	@OneToMany(mappedBy="programmeBean")
	private List<KeyResultArea> keyResultAreas;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="funder")
	private Organisation organisation;

	public Programme() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
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

}