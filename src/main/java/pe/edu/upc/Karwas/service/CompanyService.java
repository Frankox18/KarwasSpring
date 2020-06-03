package pe.edu.upc.Karwas.service;

import java.util.List;

import pe.edu.upc.Karwas.model.entity.Company;

public interface CompanyService extends CrudService<Company, Integer>{

	List<Company> findByRuc(String ruc) throws Exception;
	List<Company> findByName(String name) throws Exception;
}
