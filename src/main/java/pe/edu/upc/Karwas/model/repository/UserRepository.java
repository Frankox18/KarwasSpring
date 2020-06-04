package pe.edu.upc.Karwas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Karwas.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	// List<User> findByName(String nameUser) throws Exception;

}
