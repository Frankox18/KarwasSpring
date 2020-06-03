package pe.edu.upc.karwasspr.service;

import java.util.List;

import pe.edu.upc.karwasspr.model.entity.Person;

public interface PersonService extends CrudService<Person, Integer>{

	List<Person>findByLastName(String lastName) throws Exception;
	List<Person>findByDni(String dni) throws Exception;
}
