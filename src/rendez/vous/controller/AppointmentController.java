package rendez.vous.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Secured("ROLE_EMPLOYEE")
@Controller
public class AppointmentController 
{
	@GetMapping("/appointment")
	public String addForm(Model model)
	{
		model.addAttribute("pageTitle", "Accept Appointment");
		return "accappointment";
	}
}