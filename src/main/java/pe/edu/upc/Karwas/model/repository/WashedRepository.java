package pe.edu.upc.Karwas.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Karwas.model.entity.Washed;

@Repository
public interface WashedRepository extends JpaRepository<Washed, Integer>{

	// List<Washed> findByWashStartTime(int washStartTime) throws Exception;
}
