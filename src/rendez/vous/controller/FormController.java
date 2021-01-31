package rendez.vous.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Secured("ROLE_CHIEF")
@Controller
public class FormController 
{
	@GetMapping("/form")
	public String addForm(Model model)
	{
		model.addAttribute("pageTitle", "Add New carrier");
		return "addform";
	}
	
}