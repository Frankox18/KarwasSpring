package pe.edu.upc.Karwas.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sucursales")
@Getter
@Setter
public class Branchoffice {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "district", length = 30, nullable = false)
    private String district;
    
	@Column(name = "direction", length = 30, nullable = false)
    private String direction;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToMany(mappedBy="branchoffice", fetch = FetchType.LAZY)
    private List<Announcement> announcements;

    @ManyToMany(mappedBy = "branchoffices")
    private List<Employee> employees;
    
    public Branchoffice() {
    	announcements = new ArrayList<>();
    	employees = new ArrayList<>();
    }
}
