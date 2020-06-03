package pe.edu.upc.karwasspr.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.karwasspr.model.entity.TypeService;

@Repository
public interface TypeServiceRepository extends JpaRepository<TypeService, Integer> {

	List<TypeService> findByServiceName(String serviceName) throws Exception;
}
