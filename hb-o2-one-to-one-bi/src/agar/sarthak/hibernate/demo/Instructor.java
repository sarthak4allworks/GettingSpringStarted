package agar.sarthak.hibernate.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor 
{
	// annotate the class as an entity and map to db table

	// define the fields
	// annotate the fields with db column names
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	// ** setup mapping to instructor detail
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructionDetail;
	
	// create constructors
	public Instructor()
	{
		
	}

	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// generate getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructionDetail() {
		return instructionDetail;
	}

	public void setInstructionDetail(InstructorDetail instructionDetail) {
		this.instructionDetail = instructionDetail;
	}

	// generate toSTring() method
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructionDetail=" + instructionDetail + "]";
	}

}
