package pe.edu.upc.Karwas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("karwas/person")
@SessionAttributes("person")
public class PersonController {

}