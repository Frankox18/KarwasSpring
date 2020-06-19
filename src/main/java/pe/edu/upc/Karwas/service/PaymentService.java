package pe.edu.upc.Karwas.service;

import java.util.List;

import pe.edu.upc.Karwas.model.entity.Payment;

public interface PaymentService extends CrudService<Payment, Integer>{

	List<Payment>findByMethod(String method) throws Exception;
}
