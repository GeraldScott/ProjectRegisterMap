package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bank_accounts database table.
 * 
 */
@Entity
@Table(name="bank_accounts")
@NamedQuery(name="BankAccount.findAll", query="SELECT b FROM BankAccount b")
public class BankAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BANK_ACCOUNTS_ID_GENERATOR", sequenceName="BANK_ACCOUNTS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BANK_ACCOUNTS_ID_GENERATOR")
	private Integer id;

	@Column(name="account_name")
	private String accountName;

	@Column(name="account_number")
	private String accountNumber;

	@Column(name="account_type")
	private String accountType;

	@Column(name="branch_code")
	private String branchCode;

	@Column(name="branch_name")
	private String branchName;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="account_holder")
	private Organisation organisation1;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="bank")
	private Organisation organisation2;

	public BankAccount() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Organisation getOrganisation1() {
		return this.organisation1;
	}

	public void setOrganisation1(Organisation organisation1) {
		this.organisation1 = organisation1;
	}

	public Organisation getOrganisation2() {
		return this.organisation2;
	}

	public void setOrganisation2(Organisation organisation2) {
		this.organisation2 = organisation2;
	}

}