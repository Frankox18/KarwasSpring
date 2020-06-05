package pe.edu.upc.Karwas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Karwas.model.entity.User;
import pe.edu.upc.Karwas.service.UserService;

@Controller
@RequestMapping("karwas/user")
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login(Model model) {
		//Announcement announcement = new Announcement();
		User user = new User();
		try {
			List<User> users = userService.readAll();
			model.addAttribute("users",users);
		} catch (Exception e) {
		}
		return "/announcement/login";
	}
	
	
}
