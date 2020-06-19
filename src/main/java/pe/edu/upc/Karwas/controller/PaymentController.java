package pe.edu.upc.Karwas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.Karwas.model.entity.Payment;
import pe.edu.upc.Karwas.service.PaymentService;

@Controller
@RequestMapping("karwas/payment")
@SessionAttributes("payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	

	@GetMapping("/start")
	public String listAll(Model model) {
		try {
			List<Payment> payments = paymentService.readAll();
			model.addAttribute("payments", payments);
		} catch (Exception e) {
		}
		return "/payment/start";
	}

	@GetMapping("/new")
	public String newPayment(Model model) {
		Payment payment = new Payment();
		model.addAttribute("payment", payment);
		
		try {
			List<Payment> payments = paymentService.readAll();
			model.addAttribute("payments", payments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "/payment/nuevo";
	}
	
	@PostMapping("/save")
	public String savePayment(@ModelAttribute("payment") Payment payment, Model model, SessionStatus status) {
		try {
			paymentService.create(payment);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/payment/start";
	}
	
	@GetMapping("/edit/{id}")
	public String editPayment(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Payment> optional = paymentService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("payment", optional.get());	
				List<Payment> payments = paymentService.readAll();
				model.addAttribute("payments", payments);
			} else {
				return "redirect:/karwas/payment/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/payment/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delPayment(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Payment> optional = paymentService.findById(id);
			if (optional.isPresent()) {
				paymentService.deleteById(id);
			} else {
				return "redirect:/karwas/payment/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/payment/start";
	}	
}
