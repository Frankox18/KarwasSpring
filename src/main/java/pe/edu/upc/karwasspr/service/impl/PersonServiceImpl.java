package pe.edu.upc.karwasspr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.karwasspr.model.entity.Person;
import pe.edu.upc.karwasspr.model.repository.PersonRepository;
import pe.edu.upc.karwasspr.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	@Transactional
	public Person create(Person entity) throws Exception {
		// TODO Auto-generated method stub
		return personRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Person> readAll() throws Exception {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Person> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return personRepository.findById(id);
	}

	@Override
	@Transactional
	public Person update(Person entity) throws Exception {
		// TODO Auto-generated method stub
		return personRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		personRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		// TODO Auto-generated method stub
		personRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Person> findByLastName(String lastName) throws Exception {
		// TODO Auto-generated method stub
		return personRepository.findByLastName(lastName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Person> findByDni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return personRepository.findByDni(dni);
	}

}
