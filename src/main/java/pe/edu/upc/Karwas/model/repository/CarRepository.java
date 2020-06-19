package pe.edu.upc.Karwas.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Karwas.model.entity.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
	List<Car> findByBrand(String brand) throws Exception;
	List<Car> findByModel( String model ) throws Exception;
}
