package br.com.fiap.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.ProfileDAO;
import br.com.fiap.model.Profile;

@Named
@RequestScoped
public class ProfileBean {
	private Profile profile = new Profile();
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public void save() {
		new ProfileDAO().save(this.profile);
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Profile cadastro com sucesso"));
		System.out.println(this.profile);
	}
	
	public List<Profile> getProfiles(){
		return new ProfileDAO().getAll();
	}
}
