package pe.edu.upc.karwasspr.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.karwasspr.model.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

	List<Company> findByRuc(String ruc) throws Exception;
	List<Company> findByName(String name) throws Exception;
}
