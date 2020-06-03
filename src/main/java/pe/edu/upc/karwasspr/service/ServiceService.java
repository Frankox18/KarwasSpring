package pe.edu.upc.karwasspr.service;

import java.util.List;

import pe.edu.upc.karwasspr.model.entity.Service;


public interface ServiceService extends CrudService<Service, Integer>{
	List<Service> findByWashStartTime(int washStartTime) throws Exception;
}
