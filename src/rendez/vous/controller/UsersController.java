package rendez.vous.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/user")
public class UsersController 
{

	@GetMapping("/add")
	public String addUser(Model model)
	{
		model.addAttribute("pageTitle", "Add New user");
		return "adduser";
	}
	
	@GetMapping("/delete")
	public String deleteUser(Model model)
	{
		model.addAttribute("pageTitle", "Delete User");
		return "deluser";
	}
}