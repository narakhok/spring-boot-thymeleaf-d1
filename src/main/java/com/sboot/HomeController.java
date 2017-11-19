package com.sboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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

		User u = new User(123, "Nara", "M", "me.jpg");
		model.addAttribute("u", u);
		return "object";
	}

	@RequestMapping(value = ("/users"))
	public String userPage(Model model) {
		List<User> userList = new ArrayList<User>();

		for (int i = 0; i <= 12; i++) {
			User users = new User(i+1, "Name + i", (i > 4 ? "M" : "F"), "img.jpg");
			userList.add(users);
			model.addAttribute("userList", userList);

		}
		return "user";
	}	
	
}
