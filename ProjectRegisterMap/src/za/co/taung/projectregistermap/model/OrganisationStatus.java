package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organisation_statuses database table.
 * 
 */
@Entity
@Table(name="organisation_statuses")
@NamedQuery(name="OrganisationStatus.findAll", query="SELECT o FROM OrganisationStatus o")
public class OrganisationStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORGANISATION_STATUSES_ID_GENERATOR", sequenceName="ORGANISATION_STATUSES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORGANISATION_STATUSES_ID_GENERATOR")
	private Integer id;

	private String description;

	private String status;

	//bi-directional many-to-one association to Organisation
	@OneToMany(mappedBy="organisationStatusBean")
	private List<Organisation> organisations;

	public OrganisationStatus() {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Organisation> getOrganisations() {
		return this.organisations;
	}

	public void setOrganisations(List<Organisation> organisations) {
		this.organisations = organisations;
	}

	public Organisation addOrganisation(Organisation organisation) {
		getOrganisations().add(organisation);
		organisation.setOrganisationStatusBean(this);

		return organisation;
	}

	public Organisation removeOrganisation(Organisation organisation) {
		getOrganisations().remove(organisation);
		organisation.setOrganisationStatusBean(null);

		return organisation;
	}

}