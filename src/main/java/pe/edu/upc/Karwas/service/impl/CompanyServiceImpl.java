package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.Company;
import pe.edu.upc.Karwas.model.repository.CompanyRepository;
import pe.edu.upc.Karwas.service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;
	
    @Override
    @Transactional
	public Company create(Company entity) throws Exception {
		// TODO Auto-generated method stub
		return companyRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Company> readAll() throws Exception {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Company> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return companyRepository.findById(id);
	}

	@Override
	@Transactional
	public Company update(Company entity) throws Exception {
		// TODO Auto-generated method stub
		return companyRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		companyRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		// TODO Auto-generated method stub
		companyRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Company> findByRuc(String ruc) throws Exception {
		// TODO Auto-generated method stub
		return companyRepository.findByRuc(ruc);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Company> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return companyRepository.findByName(name);
	}

}
