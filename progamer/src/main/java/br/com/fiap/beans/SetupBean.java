package br.com.fiap.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.SetupDAO;
import br.com.fiap.model.Setup;
import br.com.fiap.model.User;

@Named
@RequestScoped
public class SetupBean {
	
	private Setup setup = new Setup();

	public void save() {
		User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		this.setup.setUser(user);
		new SetupDAO().save(this.setup);
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Setup cadastro com sucesso"));
		System.out.println(this.setup.getUser().getId());
	}
	
	public List<Setup> getSetups(){
		return new SetupDAO().getAll();
	}
	
	public List<Setup> getSetupsByUser(){
		User user = (User) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("user");
		System.out.println(user.getId());
		return new SetupDAO().getByUser(user);
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	

}
