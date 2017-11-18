package com.sboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/index")
	public String viewHomepage(ModelMap model) {
		model.addAttribute("home", "My Home page");
		return "index";
	}

	@RequestMapping("/obj")
	public String obj(ModelMap model) {

		User u = new User("123", "Nara", "M", "me.jpg");
			model.addAttribute("u",u);
		return "object";
	}

}
