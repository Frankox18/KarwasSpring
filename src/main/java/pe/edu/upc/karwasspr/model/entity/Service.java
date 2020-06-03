package pe.edu.upc.karwasspr.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "services")
@Getter
@Setter
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="description", length = 40, nullable = false)
	private int description	;
	
	@Column(name="washStartTime", length = 40, nullable = false)
	private int washStartTime;
	
	@Column(name="endTimeWashing", length = 40, nullable = false)
	private int endTimeWashing;
	
	@Column(name="totalAmount", length = 40, nullable = false)
	private int totalAmount;
	
	@ManyToMany(mappedBy = "Services")
	private List<TypeService> typesServices	;
}
