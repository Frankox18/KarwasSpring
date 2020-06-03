package pe.edu.upc.karwasspr.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.karwasspr.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	List<Person>findByLastName(String lastName) throws Exception;
	List<Person>findByDni(String dni) throws Exception;
}
