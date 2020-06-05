package pe.edu.upc.Karwas.service;

import java.util.List;

import pe.edu.upc.Karwas.model.entity.Washed;

public interface WashedService extends CrudService<Washed, Integer>{

	List<Washed> findByWashStartTime(int washStartTime) throws Exception;

}
