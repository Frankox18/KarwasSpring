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
@Table(name = "washeds")
@Getter
@Setter
public class Washed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_washed_id")
	private TypeWashed typeWashed;

	@Column(name="description", length = 40, nullable = false)
	private int description	;
	
	@Column(name="washStartTime", length = 40, nullable = false)
	private int washStartTime;
	
	@Column(name="endTimeWashing", length = 40, nullable = false)
	private int endTimeWashing;
	
	@Column(name="totalAmount", length = 40, nullable = false)
	private int totalAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "announcement_id")
	private Announcement announcement;
	
	@OneToMany(mappedBy = "washed")
	private List<WashedDetail> washedsDetails;
	
	public Washed() {
		washedsDetails = new ArrayList<>();
	}
	
	
}
