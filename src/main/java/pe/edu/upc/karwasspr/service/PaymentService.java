package pe.edu.upc.karwasspr.service;

import java.util.List;

import pe.edu.upc.karwasspr.model.entity.Payment;

public interface PaymentService extends CrudService<Payment, Integer>{

	List<Payment>findByMethod(String method) throws Exception;
}
