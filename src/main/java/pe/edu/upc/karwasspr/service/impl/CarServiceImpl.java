package pe.edu.upc.karwasspr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.karwasspr.model.entity.Car;
import pe.edu.upc.karwasspr.model.repository.CarRepository;
import pe.edu.upc.karwasspr.service.CarService;
@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;
	
	@Override
	@Transactional
	public Car create(Car entity) throws Exception {
		// TODO Auto-generated method stub
		return carRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Car> readAll() throws Exception {
		// TODO Auto-generated method stub
		return carRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Car> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return carRepository.findById(id);
	}

	@Override
	@Transactional
	public Car update(Car entity) throws Exception {
		// TODO Auto-generated method stub
		return carRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		carRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		// TODO Auto-generated method stub
		carRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Car> findByBrand(String brand) throws Exception {
		// TODO Auto-generated method stub
		return carRepository.findByBrand(brand);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Car> findByModel(String model) throws Exception {
		// TODO Auto-generated method stub
		return carRepository.findByModel(model);
	}

}
