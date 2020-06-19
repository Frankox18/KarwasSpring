package pe.edu.upc.Karwas.service;

import java.util.List;

import pe.edu.upc.Karwas.model.entity.Car;

public interface CarService extends CrudService<Car, Integer> {

	List<Car> findByBrand(String brand) throws Exception;
	List<Car> findByModel( String model ) throws Exception;
}
