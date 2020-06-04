package pe.edu.upc.Karwas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "services_details")
@Getter
@Setter
public class ServiceDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id")
	private Service service;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_service_id")
	private TypeService typeService;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private Car car;
	
	@Column(name = "start_time_wash", length = 2, nullable = false)
	private int startTimeWash;
	
	@Column(name = "end_time_wash", length = 2, nullable = false)
	private int endTimeWash;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id")
	private Payment payment;
}
