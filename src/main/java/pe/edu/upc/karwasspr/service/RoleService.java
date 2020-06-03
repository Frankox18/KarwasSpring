package pe.edu.upc.karwasspr.service;

import java.util.List;

import pe.edu.upc.karwasspr.model.entity.Role;


public interface RoleService extends CrudService<Role, Integer>{

	List<Role> findByNameRole( String nameRole ) throws Exception;
}
