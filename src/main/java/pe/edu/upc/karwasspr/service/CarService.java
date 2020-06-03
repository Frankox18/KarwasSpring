package pe.edu.upc.karwasspr.service;

import java.util.List;

import pe.edu.upc.karwasspr.model.entity.Car;

public interface CarService extends CrudService<Car, Integer> {

	List<Car> findByBrand(String brand) throws Exception;
	List<Car> findByModel( String model ) throws Exception;
}
