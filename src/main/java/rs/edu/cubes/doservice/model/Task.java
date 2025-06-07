package rs.edu.cubes.doservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private ServiceType serviceType;
	@ManyToMany
	private Set<Technician> technicians;
	private String clientName;
	private String clientContact;
	private String clientAddress;
	private TaskStatus status;
	private LocalDate assignedDate;
	private LocalDate completionDate;
	private String description;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	
	
	public Task() {
		super();
	}




	public Task(int id, ServiceType serviceType, String clientName, String clientContact, String clientAddress,
			TaskStatus status, LocalDate assignedDate, LocalDate completionDate, String description) {
		super();
		this.id = id;
		this.serviceType = serviceType;
		this.clientName = clientName;
		this.clientContact = clientContact;
		this.clientAddress = clientAddress;
		this.status = status;
		this.assignedDate = assignedDate;
		this.completionDate = completionDate;
		this.description = description;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public ServiceType getServiceType() {
		return serviceType;
	}




	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}




	public Set<Technician> getTechnicians() {
		return technicians;
	}




	public void setTechnicians(Set<Technician> technicians) {
		this.technicians = technicians;
	}




	public String getClientName() {
		return clientName;
	}




	public void setClientName(String clientName) {
		this.clientName = clientName;
	}




	public String getClientContact() {
		return clientContact;
	}




	public void setClientContact(String clientContact) {
		this.clientContact = clientContact;
	}




	public String getClientAddress() {
		return clientAddress;
	}




	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}




	public TaskStatus getStatus() {
		return status;
	}




	public void setStatus(TaskStatus status) {
		this.status = status;
	}




	public LocalDate getAssignedDate() {
		return assignedDate;
	}




	public void setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
	}




	public LocalDate getCompletionDate() {
		return completionDate;
	}




	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
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
	
	

	
	
	
	
}
