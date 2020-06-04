package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.ServiceDetail;
import pe.edu.upc.Karwas.model.repository.ServiceDetailRepository;
import pe.edu.upc.Karwas.service.ServiceDetailService;

@Service
public class ServiceDetailServiceImpl implements ServiceDetailService {

	@Autowired
	private ServiceDetailRepository serviceDetailRepository; 
	
	@Override
	@Transactional
	public ServiceDetail create(ServiceDetail entity) throws Exception {
		return serviceDetailRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ServiceDetail> readAll() throws Exception {
		return serviceDetailRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ServiceDetail> findById(Integer id) throws Exception {
		return serviceDetailRepository.findById(id);
	}

	@Override
	@Transactional
	public ServiceDetail update(ServiceDetail entity) throws Exception {
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
