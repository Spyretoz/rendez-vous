package rendez.vous.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carrier")
public class Carrier
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer id;     
    @Column(name = "carrierChief")
    private String carrierChief;
    @Column(name = "car_name")
    private String car_name;
    @Column(name = "ammountOfEmps")
    private Integer ammountOfEmps;
    @Column(name = "car_location")
    private String car_location;
    
    
    //Getters and setters
	public Carrier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Carrier(Integer id, String carrierChief, String car_name, Integer ammountOfEmps, String car_location) {
		super();
		this.id = id;
		this.carrierChief = carrierChief;
		this.car_name = car_name;
		this.ammountOfEmps = ammountOfEmps;
		this.car_location = car_location;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCarrierChief() {
		return carrierChief;
	}



	public void setCarrierChief(String carrierChief) {
		this.carrierChief = carrierChief;
	}



	public String getCar_name() {
		return car_name;
	}



	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}



	public Integer getAmmountOfEmps() {
		return ammountOfEmps;
	}



	public void setAmmountOfEmps(Integer ammountOfEmps) {
		this.ammountOfEmps = ammountOfEmps;
	}



	public String getCar_location() {
		return car_location;
	}



	public void setCar_location(String car_location) {
		this.car_location = car_location;
	}
    

}