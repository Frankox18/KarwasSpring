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

import pe.edu.upc.Karwas.model.entity.Role;
import pe.edu.upc.Karwas.service.RoleService;

@Controller
@RequestMapping("karwas/role")
@SessionAttributes("role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/start")
	public String listAll(Model model) {
		try {
			List<Role> roles = roleService.readAll();
			model.addAttribute("roles", roles);
		} catch (Exception e) {
		}
		return "/role/start";
	}

	@GetMapping("/new")
	public String newRole(Model model) {
		Role role = new Role();
		model.addAttribute("role", role);
		
		return "/role/nuevo";
	}
	
	@PostMapping("/save")
	public String saveRole(@ModelAttribute("role") Role role, Model model, SessionStatus status) {
		try {
			roleService.create(role);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/role";
	}
	
	@GetMapping("/edit/{id}")
	public String editRole(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Role> optional = roleService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("role", optional.get());				
			} else {
				return "redirect:/karwas/role";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/rol/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delRole(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Role> optional = roleService.findById(id);
			if (optional.isPresent()) {
				roleService.deleteById(id);
			} else {
				return "redirect:/karwas/role";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/karwas/role";
	}	
}
