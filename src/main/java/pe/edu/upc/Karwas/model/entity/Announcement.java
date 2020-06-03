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
@Table(name = "announcements")
@Getter
@Setter
public class Announcement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "priceService", length = 30, nullable = false)
	private Integer priceService;
	
	@Column(name = "announcementTime", length = 30, nullable = false)
	private Integer announcementTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branchOffice_id")
	private BranchOffice branchOfficel;
}
