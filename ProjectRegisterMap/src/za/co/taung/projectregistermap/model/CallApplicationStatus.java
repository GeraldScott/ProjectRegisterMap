package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the call_application_statuses database table.
 * 
 */
@Entity
@Table(name="call_application_statuses")
@NamedQuery(name="CallApplicationStatus.findAll", query="SELECT c FROM CallApplicationStatus c")
public class CallApplicationStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CALL_APPLICATION_STATUSES_ID_GENERATOR", sequenceName="CALL_APPLICATION_STATUSES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALL_APPLICATION_STATUSES_ID_GENERATOR")
	private Integer id;

	private String description;

	private String status;

	//bi-directional many-to-one association to CallApplication
	@OneToMany(mappedBy="callApplicationStatusBean")
	private List<CallApplication> callApplications;

	public CallApplicationStatus() {
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

	public List<CallApplication> getCallApplications() {
		return this.callApplications;
	}

	public void setCallApplications(List<CallApplication> callApplications) {
		this.callApplications = callApplications;
	}

	public CallApplication addCallApplication(CallApplication callApplication) {
		getCallApplications().add(callApplication);
		callApplication.setCallApplicationStatusBean(this);

		return callApplication;
	}

	public CallApplication removeCallApplication(CallApplication callApplication) {
		getCallApplications().remove(callApplication);
		callApplication.setCallApplicationStatusBean(null);

		return callApplication;
	}

}