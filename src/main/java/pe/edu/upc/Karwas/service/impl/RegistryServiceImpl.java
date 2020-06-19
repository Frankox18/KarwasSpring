package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.Registry;
import pe.edu.upc.Karwas.model.repository.RegistryRepository;
import pe.edu.upc.Karwas.service.RegistryService;

@Service
public class RegistryServiceImpl implements RegistryService {

	@Autowired
	private RegistryRepository serviceDetailRepository; 
	
	@Override
	@Transactional
	public Registry create(Registry entity) throws Exception {
		return serviceDetailRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Registry> readAll() throws Exception {
		return serviceDetailRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Registry> findById(Integer id) throws Exception {
		return serviceDetailRepository.findById(id);
	}

	@Override
	@Transactional
	public Registry update(Registry entity) throws Exception {
		return serviceDetailRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		serviceDetailRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		serviceDetailRepository.deleteAll();
	}
}
