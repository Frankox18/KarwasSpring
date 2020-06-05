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

import pe.edu.upc.Karwas.model.entity.Announcement;
import pe.edu.upc.Karwas.model.entity.Service;
import pe.edu.upc.Karwas.service.AnnouncementService;
import pe.edu.upc.Karwas.service.ServiceService;

@Controller
@RequestMapping("karwas/service")
@SessionAttributes("service")
public class ServiceController {
	
	@Autowired
	private ServiceService serviceService;
	
	@Autowired
	private AnnouncementService announcementService;
	
	@GetMapping("/start")
	public String listAll(Model model) {
		try {
			List<Service> services = serviceService.readAll();
			model.addAttribute("services", services);
		} catch (Exception e) {
		}
		return "/service/start";
	}

	@GetMapping("/new")
	public String newService(Model model) {
		Service service = new Service();
		model.addAttribute("service",service);
		
		try {
			List<Announcement> announcements = announcementService.readAll();
			model.addAttribute("announcements", announcements);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "/service/nuevo";
	}
	
	@PostMapping("/save")
	public String saveService(@ModelAttribute("service") Service service, Model model, SessionStatus status) {
		try {
			serviceService.create(service);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/service";
	}
	
	@GetMapping("/edit/{id}")
	public String editAnnouncement(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Service> optional = serviceService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("service", optional.get());				
			} else {
				return "redirect:/karwas/service";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/service/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delService(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Service> optional = serviceService.findById(id);
			if (optional.isPresent()) {
				serviceService.deleteById(id);
			} else {
				return "redirect:/karwas/service";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/service";
	}	
}
