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
	
	@Column(name = "washtype", length = 30, nullable = false)
	private String washtype;
	
	@Column(name = "washstarttime", length = 30, nullable = false)
	private Integer washstarttime;
	
	@Column(name = "endtimewashing", length = 30, nullable = false)
	private Integer endtimewashing;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private Car car;

}
