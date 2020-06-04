package pe.edu.upc.Karwas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Karwas.model.entity.ServiceDetail;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetail, Integer> {
	//
}
