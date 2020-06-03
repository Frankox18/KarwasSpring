package pe.edu.upc.Karwas.service;

import java.util.List;

import pe.edu.upc.Karwas.model.entity.Service;


public interface ServiceService extends CrudService<Service, Integer>{
	List<Service> findByWashStartTime(int washStartTime) throws Exception;
}
