package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organisation_types database table.
 * 
 */
@Entity
@Table(name="organisation_types")
@NamedQuery(name="OrganisationType.findAll", query="SELECT o FROM OrganisationType o")
public class OrganisationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String description;

	private String type;

	//bi-directional many-to-one association to Organisation
	@OneToMany(mappedBy="organisationTypeBean")
	private List<Organisation> organisations;

	public OrganisationType() {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Organisation> getOrganisations() {
		return this.organisations;
	}

	public void setOrganisations(List<Organisation> organisations) {
		this.organisations = organisations;
	}

	public Organisation addOrganisation(Organisation organisation) {
		getOrganisations().add(organisation);
		organisation.setOrganisationTypeBean(this);

		return organisation;
	}

	public Organisation removeOrganisation(Organisation organisation) {
		getOrganisations().remove(organisation);
		organisation.setOrganisationTypeBean(null);

		return organisation;
	}

}