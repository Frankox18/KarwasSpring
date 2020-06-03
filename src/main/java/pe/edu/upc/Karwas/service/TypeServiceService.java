package pe.edu.upc.Karwas.service;

import java.util.List;

import pe.edu.upc.Karwas.model.entity.TypeService;

public interface TypeServiceService extends CrudService<TypeService, Integer>{

	List<TypeService> findByServiceName(String serviceName) throws Exception;
}
