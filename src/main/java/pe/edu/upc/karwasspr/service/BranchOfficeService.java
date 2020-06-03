package pe.edu.upc.karwasspr.service;

import java.util.List;

import pe.edu.upc.karwasspr.model.entity.BranchOffice;

public interface BranchOfficeService extends CrudService<BranchOffice, Integer> {

	List<BranchOffice> findByDistrict(String district) throws Exception;
}
