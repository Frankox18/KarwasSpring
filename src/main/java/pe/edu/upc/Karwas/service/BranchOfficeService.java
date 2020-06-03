package pe.edu.upc.Karwas.service;

import java.util.List;

import pe.edu.upc.Karwas.model.entity.BranchOffice;

public interface BranchOfficeService extends CrudService<BranchOffice, Integer> {

	List<BranchOffice> findByDistrict(String district) throws Exception;
}
