package rendez.vous.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application")
public class Form 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	private int id;
	@Column(name = "a_chief")
	private String chiefName;
	@Column(name = "a_carrier")
	private String carrierName;
	@Column(name = "a_ammountOfEmps")
	private String a_amountOfEmps;
	@Column(name = "carrierLocation")
	private String carrierLocation;
	
	public Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Form(int id, String chiefName, String carrierName, String a_amountOfEmps, String carrierLocation) {
		super();
		this.id = id;
		this.chiefName = chiefName;
		this.carrierName = carrierName;
		this.a_amountOfEmps = a_amountOfEmps;
		this.carrierLocation = carrierLocation;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChiefName() {
		return chiefName;
	}

	public void setChiefName(String chiefName) {
		this.chiefName = chiefName;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}


	public String getA_amountOfEmps() {
		return a_amountOfEmps;
	}


	public void setA_amountOfEmps(String a_amountOfEmps) {
		this.a_amountOfEmps = a_amountOfEmps;
	}


	public String getCarrierLocation() {
		return carrierLocation;
	}


	public void setCarrierLocation(String carrierLocation) {
		this.carrierLocation = carrierLocation;
	}
	
	
	
	
}