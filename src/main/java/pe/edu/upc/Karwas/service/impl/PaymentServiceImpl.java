package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.Payment;
import pe.edu.upc.Karwas.model.repository.PaymentRepository;
import pe.edu.upc.Karwas.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	@Transactional
	public Payment create(Payment entity) throws Exception {
		// TODO Auto-generated method stub
		return paymentRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Payment> readAll() throws Exception {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Payment> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return paymentRepository.findById(id);
	}

	@Override
	@Transactional
	public Payment update(Payment entity) throws Exception {
		// TODO Auto-generated method stub
		return paymentRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		paymentRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		// TODO Auto-generated method stub
		paymentRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Payment> findByMethod(String method) throws Exception {
		// TODO Auto-generated method stub
		return paymentRepository.findByMethod(method);
	}

}
