package pe.edu.upc.karwasspr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.karwasspr.model.entity.Role;
import pe.edu.upc.karwasspr.model.repository.RoleRepository;
import pe.edu.upc.karwasspr.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    
	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public Role create(Role entity) throws Exception {
		return roleRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> readAll() throws Exception {
		return roleRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Role> findById(Integer id) throws Exception {
		return roleRepository.findById(id);
	}

	@Override
	@Transactional
	public Role update(Role entity) throws Exception {
		return roleRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		roleRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		roleRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> findByNameRole(String nameRole) throws Exception {
		return roleRepository.findByNameRole(nameRole);
	}
    
	
}
