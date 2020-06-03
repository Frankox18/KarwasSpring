package pe.edu.upc.karwasspr.service;

import java.util.List;
import pe.edu.upc.karwasspr.model.entity.Company;

public interface CompanyService extends CrudService<Company, Integer>{

	List<Company> findByRuc(String ruc) throws Exception;
	List<Company> findByName(String name) throws Exception;
}
