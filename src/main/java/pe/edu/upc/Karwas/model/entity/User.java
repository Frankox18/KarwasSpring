package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email", length = 30, nullable = false)
    private String email;
	
	@Column(name = "password", length = 30, nullable = false)
    private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;
	
	@OneToMany(mappedBy = "user")
	private List<Car> car;
	
	@OneToMany(mappedBy = "user")
	private List<UserBranchoffice> userBranchoffices;
	
	public User() {
		car = new ArrayList<>();
		userBranchoffices = new ArrayList<>();
	}
	
}
