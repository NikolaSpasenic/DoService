package rs.edu.cubes.doservice.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Technician {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private TechnicianStatus status;
	@ManyToOne
	private TechnicianSpecialization specialization;
	@ManyToOne
	private Location location;
	private LocalDateTime employmentDate;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	@ManyToMany
	private Set<Task> tasks;
	
	
	
	
	
	public Technician() {
		super();
	}




	public Technician(int id, String firstName, String lastName, String email, String phone, TechnicianStatus status,
			TechnicianSpecialization specialization, Location location, LocalDateTime employmentDate,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.specialization = specialization;
		this.location = location;
		this.employmentDate = employmentDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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




	public TechnicianStatus getStatus() {
		return status;
	}




	public void setStatus(TechnicianStatus status) {
		this.status = status;
	}




	public TechnicianSpecialization getSpecialization() {
		return specialization;
	}




	public void setSpecialization(TechnicianSpecialization specialization) {
		this.specialization = specialization;
	}




	public Location getLocation() {
		return location;
	}




	public void setLocation(Location location) {
		this.location = location;
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




	public Set<Task> getTasks() {
		return tasks;
	}




	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
	

}
