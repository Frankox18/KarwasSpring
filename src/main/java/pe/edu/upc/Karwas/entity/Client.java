package pe.edu.upc.Karwas.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "cli_person")
@Table(name = "clients")
@Getter
@Setter
public class Client extends Person {
	
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Car> cars;
    
    public Client() {
    	cars = new ArrayList<>();
    }

}
