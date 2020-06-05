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

import pe.edu.upc.Karwas.model.entity.Company;
import pe.edu.upc.Karwas.service.CompanyService;

@Controller
@RequestMapping("karwas/company")
@SessionAttributes("company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/start")
	public String listAll(Model model) {
		try {
			List<Company> companies = companyService.readAll();
			model.addAttribute("companies",companies);
		} catch (Exception e) {
		}
		return "/company/start";
	}

	@GetMapping("/new")
	public String newCompany(Model model) {
		Company company = new Company();
		model.addAttribute("company", company);

		return "/company/nuevo";
	}
	
	@PostMapping("/save")
	public String saveCompany(@ModelAttribute("company") Company company, Model model, SessionStatus status) {
		try {
			companyService.create(company);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/company";
	}
	
	@GetMapping("/edit/{id}")
	public String editCompany(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Company> optional = companyService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("company", optional.get());				
			} else {
				return "redirect:/karwas/company";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/company/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delCompany(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Company> optional = companyService.findById(id);
			if (optional.isPresent()) {
				companyService.deleteById(id);
			} else {
				return "redirect:/karwas/company";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/company";
	}	
}
