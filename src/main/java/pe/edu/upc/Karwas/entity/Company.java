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
import javax.validation.constraints.NotBlank;

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
    
	@NotBlank(message = "Name is required")
	@Column(name = "name", length = 30, nullable = false)
    private String name;

	@NotBlank(message = "Ruc is required")
	@Column(name = "ruc", length = 30, nullable = false)
    private Long ruc;
   
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Branchoffice> branchoffice;

	public Company() {
		branchoffice = new ArrayList<>();
	}


}
