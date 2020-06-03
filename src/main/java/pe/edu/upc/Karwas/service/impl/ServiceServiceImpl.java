package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.Service;
import pe.edu.upc.Karwas.model.repository.ServiceRepository;
import pe.edu.upc.Karwas.service.ServiceService;

public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	@Transactional
	public Service create(Service entity) throws Exception {
		return serviceRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Service> readAll() throws Exception {
		return serviceRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Service> findById(Integer id) throws Exception {
		return serviceRepository.findById(id);
	}

	@Override
	@Transactional
	public Service update(Service entity) throws Exception {
		return serviceRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		serviceRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		serviceRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Service> findByWashStartTime(int washStartTime) throws Exception {
		return serviceRepository.findByWashStartTime(washStartTime);
	}
}
