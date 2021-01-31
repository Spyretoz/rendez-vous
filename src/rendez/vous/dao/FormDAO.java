package rendez.vous.dao;

import java.util.List;

import rendez.vous.entity.Form;

public interface FormDAO 
{
	public List<Form> getForms();

	public void saveForm(Form theForm);
	
	public Form getForm(int id);
	public void deleteForm(int id);

}