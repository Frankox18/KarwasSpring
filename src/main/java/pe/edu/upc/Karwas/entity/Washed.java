package pe.edu.upc.Karwas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "washes")
@Getter
@Setter
public class Washed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Wash type is required")
	@Column(name = "washtype", length = 30, nullable = false)
	private String washtype;
	
	@Past(message = "The washing start date must be a past date")
	@Column(name = "washstarttime", length = 30, nullable = false)
	private Integer washstarttime;
	
	@NotBlank(message = "End time washing is required")
	@Column(name = "endtimewashing", length = 30, nullable = false)
	private Integer endtimewashing;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private Car car;


}
