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
import pe.edu.upc.Karwas.model.entity.ServiceDetail;
import pe.edu.upc.Karwas.service.PaymentService;
import pe.edu.upc.Karwas.service.ServiceDetailService;

@Controller
@RequestMapping("karwas/servicedetail")
@SessionAttributes("service_detail")
public class ServiceDetailController {

	@Autowired
	private ServiceDetailService serviceDetailService;
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/start")
	public String listAll(Model model) {
		try {
			List<ServiceDetail> serviceDetails = serviceDetailService.readAll();
			model.addAttribute("service_details", serviceDetails);
		} catch (Exception e) {
		}
		return "/servicedetail/start";
	}

	@GetMapping("/new")
	public String newServiceDetail(Model model) {
		ServiceDetail serviceDetail = new ServiceDetail();
		model.addAttribute("service_detail", serviceDetail);
		
		try {
			List<Payment> payments = paymentService.readAll();
			model.addAttribute("payments", payments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "/servicedetail/nuevo";
	}
	
	@PostMapping("/save")
	public String saveServiceDetail(@ModelAttribute("service_detail") ServiceDetail serviceDetail, Model model, SessionStatus status) {
		try {
			serviceDetailService.create(serviceDetail);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/servicedetail";
	}
	
	@GetMapping("/edit/{id}")
	public String editServiceDetail(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<ServiceDetail> optional = serviceDetailService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("service_detail", optional.get());				
			} else {
				return "redirect:/karwas/servicedetail";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/servicedetail/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delServiceDetail(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<ServiceDetail> optional = serviceDetailService.findById(id);
			if (optional.isPresent()) {
				serviceDetailService.deleteById(id);
			} else {
				return "redirect:/karwas/servicedetail";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/servicedetail";
	}	
}
