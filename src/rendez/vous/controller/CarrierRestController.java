package rendez.vous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rendez.vous.dao.CarrierDAO;
import rendez.vous.entity.Carrier;

//@Secured("ROLE_MANAGER")
@RestController
@RequestMapping("/carrier")
public class CarrierRestController 
{

	// inject the carrier dao
    @Autowired
    private CarrierDAO carrierDAO;
    
    
    // add new carrier
    @PostMapping("/add")
    public Carrier addCarrier(@RequestBody Carrier theCarrier) 
    {  
    	theCarrier.setId(0);
    	carrierDAO.saveCarrier(theCarrier);
        return theCarrier;
    }
    
    // show all carriers
 	@GetMapping("/show")
	public List<Carrier> getCarriers() 
	{
 		List<Carrier> carriers = carrierDAO.getCarriers();
 		return carriers;
	}
}