package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "announcements")
@Getter
@Setter
public class Announcement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "description", length = 30, nullable = false)
	private String description;
	
	@Column(name = "announcementTime", length = 30, nullable = false)
	private Date announcementTime;
	
	@OneToMany(mappedBy = "announcement")
	private List<Service> service;
	
    public Announcement(){
		service = new ArrayList<>();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branchOffice_id")
	private BranchOffice branchOffice;
}