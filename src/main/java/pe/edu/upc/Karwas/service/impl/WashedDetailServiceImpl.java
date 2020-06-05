package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.WashedDetail;
import pe.edu.upc.Karwas.model.repository.WashedDetailRepository;
import pe.edu.upc.Karwas.service.WashedDetailService;

@Service
public class WashedDetailServiceImpl implements WashedDetailService {

	@Autowired
	private WashedDetailRepository serviceDetailRepository; 
	
	@Override
	@Transactional
	public WashedDetail create(WashedDetail entity) throws Exception {
		return serviceDetailRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<WashedDetail> readAll() throws Exception {
		return serviceDetailRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<WashedDetail> findById(Integer id) throws Exception {
		return serviceDetailRepository.findById(id);
	}

	@Override
	@Transactional
	public WashedDetail update(WashedDetail entity) throws Exception {
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
