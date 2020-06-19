package pe.edu.upc.Karwas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Karwas.model.entity.Registry;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Integer> {
	//
}
