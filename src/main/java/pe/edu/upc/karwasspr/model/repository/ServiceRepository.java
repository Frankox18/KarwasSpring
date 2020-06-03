package pe.edu.upc.karwasspr.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.karwasspr.model.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer>{

	List<Service> findByWashStartTime(int washStartTime) throws Exception;
}
