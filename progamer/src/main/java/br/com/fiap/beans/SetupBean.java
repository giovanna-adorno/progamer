package br.com.fiap.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.SetupDAO;
import br.com.fiap.model.Setup;

@Named
@RequestScoped
public class SetupBean {
	
	private Setup setup = new Setup();

	public void save() {
		new SetupDAO().save(this.setup);
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Setup cadastro com sucesso"));
		System.out.println(this.setup);
	}
	
	public List<Setup> getSetups(){
		return new SetupDAO().getAll();
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	

}
