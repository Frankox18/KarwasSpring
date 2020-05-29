package pe.edu.upc.Karwas.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "name", length = 30, nullable = false)
    private String name;
    
	@Column(name = "ruc", length = 30, nullable = false)
    private Long ruc;
   
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Branchoffice> branchoffice;

	public Company() {
		branchoffice = new ArrayList<>();
	}
    

}
