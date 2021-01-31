package rendez.vous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rendez.vous.dao.AppointmentDAO;
import rendez.vous.entity.Appointment;

@Secured("ROLE_EMPLOYEE")
@RestController
@RequestMapping("/appointment")
public class AppointmentRestController 
{
	// inject the appointment dao
    @Autowired
    private AppointmentDAO appointmentDAO;
    
    
    @PutMapping("/update")
    public Appointment updateAppointment(@RequestBody Appointment theAppointment) 
    {
    	appointmentDAO.saveAppointment(theAppointment);
            
    	return theAppointment;
    }


    
    // show all appointments
	@GetMapping("/show")
    public List<Appointment> getAppointments() 
	{
		List<Appointment> appointments = appointmentDAO.getAppointments();
        return appointments;
    }
}
