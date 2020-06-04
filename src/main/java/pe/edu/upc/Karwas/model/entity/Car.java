package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "license", length = 30, nullable = false)
	private Integer license;
	
	@Column(name = "brand", length = 30, nullable = false)
	private String brand;
	
	@Column(name = "model", length = 30, nullable = false)
	private String model;
	
	@Column(name = "carType", length = 30, nullable = false)
	private String carType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "car")
	private List<ServiceDetail> servicesDetails;
	
	public Car() {
		servicesDetails = new ArrayList<>();
	}
}
