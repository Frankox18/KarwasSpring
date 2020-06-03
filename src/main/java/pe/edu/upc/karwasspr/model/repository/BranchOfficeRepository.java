package pe.edu.upc.karwasspr.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.karwasspr.model.entity.BranchOffice;
@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Integer>  {

	List<BranchOffice> findByDistrict(String district) throws Exception;

}
