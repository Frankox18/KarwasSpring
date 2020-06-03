package pe.edu.upc.karwasspr.service;

import java.util.Optional;


import pe.edu.upc.karwasspr.model.entity.User;

public interface UserService extends CrudService<User, Integer>{
	Optional<User> findByNameUser(String nameUser) throws Exception;
}
