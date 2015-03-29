package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the call_evaluations database table.
 * 
 */
@Entity
@Table(name="call_evaluations")
@NamedQuery(name="CallEvaluation.findAll", query="SELECT c FROM CallEvaluation c")
public class CallEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CALL_EVALUATIONS_ID_GENERATOR", sequenceName="CALL_EVALUATIONS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALL_EVALUATIONS_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="evaluation_date")
	private Date evaluationDate;

	private String remarks;

	private Integer score;

	//bi-directional many-to-one association to CallApplication
	@ManyToOne
	@JoinColumn(name="call_application")
	private CallApplication callApplicationBean;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="assessor")
	private Person person;

	public CallEvaluation() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getEvaluationDate() {
		return this.evaluationDate;
	}

	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public CallApplication getCallApplicationBean() {
		return this.callApplicationBean;
	}

	public void setCallApplicationBean(CallApplication callApplicationBean) {
		this.callApplicationBean = callApplicationBean;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}