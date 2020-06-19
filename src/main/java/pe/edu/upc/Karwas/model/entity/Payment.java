package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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

	@Column(name = "number_card", length = 16, nullable = false)
	private Long numberCard;

	@Column(name = "date_exp", length = 30, nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateExp;

	@Column(name = "cvv", length = 3, nullable = false)
	private int cvv;

	@OneToMany(mappedBy = "payment")
	private List<Registry> servicesDetails;

	public Payment() {
		servicesDetails = new ArrayList<>();
	}
}
