package rendez.vous.dao;

import java.util.List;

import rendez.vous.entity.Carrier;

public interface CarrierDAO 
{
	public List<Carrier> getCarriers();

	public void saveCarrier(Carrier theCarrier);
	
	public Carrier getCarrier(int id);
	public void deleteCarrier(int id);
}