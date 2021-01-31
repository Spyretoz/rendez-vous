package rendez.vous.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Secured("ROLE_MANAGER")
@Controller
public class CarrierController 
{
	@GetMapping("/carrier")
	public String addCarrier(Model model)
	{
		model.addAttribute("pageTitle", "Add Carrier");
		return "addcarrier";
	}
}