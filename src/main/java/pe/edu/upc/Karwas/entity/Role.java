package pe.edu.upc.Karwas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.Karwas.entity.Person;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 40, nullable = false)
	private String rolename;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person person;
		
}
