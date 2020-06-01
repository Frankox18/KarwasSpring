package pe.edu.upc.Karwas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "announcements")
@Getter
@Setter
public class Announcement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Service price is required")
	@Column(name = "serviceprice", length = 30, nullable = false)
	private Integer serviceprice;
	
	@Past(message = "The time announcement must be a past date")
	@Column(name = "announcementtime", length = 30, nullable = false)
	private Integer announcementtime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branchoffice_id")
	private Branchoffice branchoffice;

	
}

