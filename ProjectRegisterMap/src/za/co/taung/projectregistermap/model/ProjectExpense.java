package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_expenses database table.
 * 
 */
@Entity
@Table(name="project_expenses")
@NamedQuery(name="ProjectExpense.findAll", query="SELECT p FROM ProjectExpense p")
public class ProjectExpense implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECT_EXPENSES_ID_GENERATOR", sequenceName="PROJECT_EXPENSES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_EXPENSES_ID_GENERATOR")
	private Integer id;

	private String description;

	@Column(name="payment_reference")
	private String paymentReference;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project")
	private Project projectBean;

	public ProjectExpense() {
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

	public String getPaymentReference() {
		return this.paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	public Project getProjectBean() {
		return this.projectBean;
	}

	public void setProjectBean(Project projectBean) {
		this.projectBean = projectBean;
	}

}