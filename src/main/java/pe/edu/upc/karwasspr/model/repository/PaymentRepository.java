package pe.edu.upc.karwasspr.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.karwasspr.model.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	List<Payment>findByMethod(String method) throws Exception;
}
