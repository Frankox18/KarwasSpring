package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "method", length = 30, nullable = false)
    private String method;
	
	@OneToMany(mappedBy = "payment")
	private List<WashedDetail> servicesDetails;
	
	public Payment() {
		servicesDetails = new ArrayList<>();
	}
}
