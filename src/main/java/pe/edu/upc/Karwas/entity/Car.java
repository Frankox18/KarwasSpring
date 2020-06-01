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

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.Karwas.entity.Client;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "License is required")
	@Column(name = "license", length = 30, nullable = false)
	private Integer license;
	
	@NotBlank(message = "Brand is required")
	@Column(name = "brand", length = 30, nullable = false)
	private String brand;
	
	@NotBlank(message = "Model is required")
	@Column(name = "model", length = 30, nullable = false)
	private String model;
	
	@NotBlank(message = "Car type is required")
	@Column(name = "cartype", length = 30, nullable = false)
	private String cartype;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToOne(mappedBy = "car")
	private Washed washed; 

	
}
