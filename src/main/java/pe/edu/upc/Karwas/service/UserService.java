package pe.edu.upc.Karwas.service;

import java.util.Optional;

import pe.edu.upc.Karwas.model.entity.User;

public interface UserService extends CrudService<User, Integer>{
	Optional<User> findByNameUser(String nameUser) throws Exception;
}
