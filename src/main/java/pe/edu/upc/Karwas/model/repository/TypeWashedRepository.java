package pe.edu.upc.Karwas.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Karwas.model.entity.TypeWashed;

@Repository
public interface TypeWashedRepository extends JpaRepository<TypeWashed, Integer> {

	List<TypeWashed> findByServiceName(String serviceName) throws Exception;
}
