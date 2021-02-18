package rendez.vous.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_id", unique = true, nullable = false, updatable = false)
	private int id;
	@Column(name = "app_time", updatable = false)
	private String time;
	@Column(name = "app_date", updatable = false)
	private String date;
	@Column(name = "app_citizen", updatable = false)
	private String citizen;
	@Column(name = "app_carrier", updatable = false)
	private String carrier;
	@Column(name = "app_extraINFO", updatable = false)
	private String info;
	@Column(name = "accepted", updatable = true)
	private int accepted;
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(int id, String time, String date, String citizen, String carrier, String info, int accepted) {
		super();
		this.id = id;
		this.time = time;
		this.date = date;
		this.citizen = citizen;
		this.carrier = carrier;
		this.info = info;
		this.accepted = accepted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCitizen() {
		return citizen;
	}
	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getAccepted() {
		return accepted;
	}
	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}
	

}