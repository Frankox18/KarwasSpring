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

import pe.edu.upc.Karwas.model.entity.Person;
import pe.edu.upc.Karwas.model.entity.Role;
import pe.edu.upc.Karwas.model.entity.User;
import pe.edu.upc.Karwas.service.PersonService;
import pe.edu.upc.Karwas.service.RoleService;
import pe.edu.upc.Karwas.service.UserService;

@Controller
@RequestMapping("karwas/user")
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/start")
	public String listAll(Model model) {
		try {
			List<User> users = userService.readAll();
			model.addAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/start";
	}
	
	@GetMapping("/new")
	public String newUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);	
		try {
			List<Person> persons = personService.readAll();
			model.addAttribute("persons", persons);
			List<Role> roles = roleService.readAll();
			model.addAttribute("roles", roles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/login";
	}
	
	@PostMapping("/save")
 	public String saveUser(@ModelAttribute("user") User user, Model model, SessionStatus status) {
 		try {
 			userService.create(user);
 			status.setComplete();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return "redirect:/karwas/user/start";
 	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<User> optional = userService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("user", optional.get());
				List<Person> persons = personService.readAll();
				model.addAttribute("persons", persons);
				List<Role> roles = roleService.readAll();
				model.addAttribute("roles", roles);
			} else {
				return "redirect:/karwas/user/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delUser(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<User> optional = userService.findById(id);
			if (optional.isPresent()) {
				userService.deleteById(id);
			} else {
				return "redirect:/karwas/user/start";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/karwas/user/start";
	}
}
