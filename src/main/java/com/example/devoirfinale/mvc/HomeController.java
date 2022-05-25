package com.example.devoirfinale.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.devoirfinale.model.User;
import com.example.devoirfinale.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "connexion";
	}
	
	
	
}
