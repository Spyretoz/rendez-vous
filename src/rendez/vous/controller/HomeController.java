package rendez.vous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController 
{
	@GetMapping("/")
	public String hello(Model model)
	{
		model.addAttribute("pageTitle", "Rendez-Vous");		
		return "home";
	}
	
	
	@GetMapping("/profile")
	public String showprofile(Model model)
	{
		model.addAttribute("pageTitle", "Profile");
		return "profile";
	}
	
	

}
