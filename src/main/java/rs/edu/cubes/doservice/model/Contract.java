package rs.edu.cubes.doservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private BigDecimal salary;
	private LocalDate signingDate;
	private LocalDate anulmentDate;
	@ManyToOne
	private Position position;
	@ManyToOne
	private Employee employee;
	
	
	
	
	
	public Contract() {
		super();
	}



	public Contract(int id, BigDecimal salary, LocalDate signingDate, LocalDate anulmentDate, Position position,
			Employee employee) {
		super();
		this.id = id;
		this.salary = salary;
		this.signingDate = signingDate;
		this.anulmentDate = anulmentDate;
		this.position = position;
		this.employee = employee;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public BigDecimal getSalary() {
		return salary;
	}



	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}



	public LocalDate getSigningDate() {
		return signingDate;
	}



	public void setSigningDate(LocalDate signingDate) {
		this.signingDate = signingDate;
	}



	public LocalDate getAnulmentDate() {
		return anulmentDate;
	}



	public void setAnulmentDate(LocalDate anulmentDate) {
		this.anulmentDate = anulmentDate;
	}



	public Position getPosition() {
		return position;
	}



	public void setPosition(Position position) {
		this.position = position;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
	
	
	
	
	
	
	

}
