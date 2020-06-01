package pe.edu.upc.Karwas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name is required")
	@Column(name="name", length=13, nullable=false)
	private String namePerson;
	
	@NotBlank(message = "Last name is required")
	@Column(name="last_name", length=30, nullable=false)
	private String lastNamePerson;
	
	@Size(min = 8, max = 8, message = "The DNI must be 8 digits")
	@Column(name = "dni", length = 8, nullable = false)
	private Integer dni;
	
	@NotBlank(message = "Phone number is required")
	@Column(name = "number_phone", length = 9, nullable = false)
	private Integer numberPhone;
	
	@NotBlank(message = "District is required")
	@Column(name="district", length=20, nullable=false)
	private String district;
	
	@NotBlank(message = "Direction is required")
	@Column(name="direction", length=40, nullable=false)
	private String direction;

}
