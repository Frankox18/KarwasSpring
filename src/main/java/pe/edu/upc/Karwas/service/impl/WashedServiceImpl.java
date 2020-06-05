package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.Washed;
import pe.edu.upc.Karwas.model.repository.WashedRepository;
import pe.edu.upc.Karwas.service.WashedService;

@Service
public class WashedServiceImpl implements WashedService {

	@Autowired
	private WashedRepository washedRepository;

	@Override
	@Transactional
	public Washed create(Washed entity) throws Exception {
		return washedRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Washed> readAll() throws Exception {
		return washedRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Washed> findById(Integer id) throws Exception {
		return washedRepository.findById(id);
	}

	@Override
	@Transactional
	public Washed update(Washed entity) throws Exception {
		return washedRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		washedRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		washedRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Washed> findByWashStartTime(int washStartTime) throws Exception {
		return washedRepository.findByWashStartTime(washStartTime);
	}
}
