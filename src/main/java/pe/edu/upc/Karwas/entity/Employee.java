package pe.edu.upc.Karwas.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "emp_person")
@Table(name="Employees")
@Getter
@Setter
public class Employee extends Person {
			
	@Size(min = 8, max = 8, message = "The employee code must be 10 digits")
	@Column(name = "codeemployee", length = 10, nullable = false)
	private long codeemployee;

	@ManyToMany
	@JoinTable(name="branchoffice_employee", 
		joinColumns = { @JoinColumn(name = "employee_id", referencedColumnName = "id") }, 
		inverseJoinColumns = { @JoinColumn(name = "branchoffice_id", referencedColumnName = "id") } )
	private List<Branchoffice> branchoffices;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<Washed> washes; 
	
	public Employee() {
		branchoffices = new ArrayList<>();
		washes = new ArrayList<>();
	}

}
