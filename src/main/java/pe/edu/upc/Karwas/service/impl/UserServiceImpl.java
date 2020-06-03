package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.User;
import pe.edu.upc.Karwas.model.repository.UserRepository;
import pe.edu.upc.Karwas.service.UserService;
@Repository
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	@Transactional
	public User create(User entity) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> readAll() throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public User update(User entity) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findByNameUser(String nameUser) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findByNameUser(nameUser);
	}

}
