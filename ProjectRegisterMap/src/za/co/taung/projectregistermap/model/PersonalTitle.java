package za.co.taung.projectregistermap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the personal_titles database table.
 * 
 */
@Entity
@Table(name="personal_titles")
@NamedQuery(name="PersonalTitle.findAll", query="SELECT p FROM PersonalTitle p")
public class PersonalTitle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONAL_TITLES_ID_GENERATOR", sequenceName="PERSONAL_TITLES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONAL_TITLES_ID_GENERATOR")
	private Integer id;

	private String description;

	private String title;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="personalTitleBean")
	private List<Person> persons;

	public PersonalTitle() {
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setPersonalTitleBean(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setPersonalTitleBean(null);

		return person;
	}

}