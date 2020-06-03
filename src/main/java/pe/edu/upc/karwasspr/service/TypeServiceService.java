package pe.edu.upc.karwasspr.service;

import java.util.List;

import pe.edu.upc.karwasspr.model.entity.TypeService;

public interface TypeServiceService extends CrudService<TypeService, Integer>{

	List<TypeService> findByServiceName(String serviceName) throws Exception;
}
