package rs.edu.cubes.doservice.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String phone;
	protected LocalDateTime employmentDate;
	protected LocalDateTime createdAt;
	protected LocalDateTime updatedAt;
	@OneToMany(mappedBy="employee")
	protected Set<Contract> contracts;
	
	
	
	
	
	
	public Employee() {
		super();
	}



	public Employee(int id, String firstName, String lastName, String email, String phone, LocalDateTime employmentDate,
			LocalDateTime createdAt, LocalDateTime updatedAt, Set<Contract> contracts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.employmentDate = employmentDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.contracts = contracts;
	}



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



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public LocalDateTime getEmploymentDate() {
		return employmentDate;
	}



	public void setEmploymentDate(LocalDateTime employmentDate) {
		this.employmentDate = employmentDate;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Set<Contract> getContracts() {
		return contracts;
	}



	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}
	
	
	
	
	
	
	
	
	

}
