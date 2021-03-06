package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.User;
import pe.edu.upc.Karwas.model.repository.UserRepository;
import pe.edu.upc.Karwas.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public User create(User entity) throws Exception {
		return userRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> readAll() throws Exception {
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
		return userRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		userRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		userRepository.deleteAll();
	}

}
