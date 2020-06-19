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

import pe.edu.upc.Karwas.model.entity.BranchOffice;
import pe.edu.upc.Karwas.model.entity.Company;
import pe.edu.upc.Karwas.service.BranchOfficeService;
import pe.edu.upc.Karwas.service.CompanyService;


@Controller
@RequestMapping("karwas/branchoffice")
@SessionAttributes("branchoffice")
public class BranchOfficeController {

	@Autowired
	private BranchOfficeService branchOfficeService;
	
	@Autowired
	private CompanyService companyService;

	@GetMapping("/start")
	public String listAll(Model model) {
		try {
			List<BranchOffice> branchoffices = branchOfficeService.readAll();
			model.addAttribute("branchoffices", branchoffices);
		} catch (Exception e) {
		}
		return "/branchoffice/start";
	}

	@GetMapping("/new")
	public String newBranchOffice(Model model) {
		BranchOffice branchoffice = new BranchOffice();
		model.addAttribute("branchoffice", branchoffice);
		try {
			List<Company> companys = companyService.readAll();
			model.addAttribute("companys", companys);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/branchoffice/login";
	}

	@PostMapping("/save")
	public String saveBranchOffice(@ModelAttribute("branchoffice") BranchOffice branchoffice, Model model,
			SessionStatus status) {
		try {
			branchOfficeService.create(branchoffice);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/branchoffice/start";
	}

	@GetMapping("/edit/{id}")
	public String editBranchOffice(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<BranchOffice> optional = branchOfficeService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("branchoffice", optional.get());
			} else {
				return "redirect:/karwas/branchoffice/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/branchoffice/edit";
	}

	@GetMapping("/del/{id}")
	public String delBranchOffice(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<BranchOffice> optional = branchOfficeService.findById(id);
			if (optional.isPresent()) {
				branchOfficeService.deleteById(id);
			} else {
				return "redirect:/karwas/branchoffice/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/branchoffice/start";
	}
}