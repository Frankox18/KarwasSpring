package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.BranchOffice;
import pe.edu.upc.Karwas.model.repository.BranchOfficeRepository;
import pe.edu.upc.Karwas.service.BranchOfficeService;
@Service
public class BranchOffinceServiceImpl implements BranchOfficeService {

	@Autowired
	private BranchOfficeRepository branchOfficeRepository;
	@Override
	@Transactional
	public BranchOffice create(BranchOffice entity) throws Exception {
		// TODO Auto-generated method stub
		return branchOfficeRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BranchOffice> readAll() throws Exception {
		// TODO Auto-generated method stub
		return branchOfficeRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<BranchOffice> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return branchOfficeRepository.findById(id);
	}

	@Override
	@Transactional
	public BranchOffice update(BranchOffice entity) throws Exception {
		// TODO Auto-generated method stub
		return branchOfficeRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		branchOfficeRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		// TODO Auto-generated method stub
		branchOfficeRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<BranchOffice> findByDistrict(String district) throws Exception {
		// TODO Auto-generated method stub
		return branchOfficeRepository.findByDistrict(district);
	}

}
