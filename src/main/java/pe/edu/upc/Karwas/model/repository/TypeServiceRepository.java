package pe.edu.upc.Karwas.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Karwas.model.entity.TypeService;

@Repository
public interface TypeServiceRepository extends JpaRepository<TypeService, Integer> {

	List<TypeService> findByServiceName(String serviceName) throws Exception;
}
