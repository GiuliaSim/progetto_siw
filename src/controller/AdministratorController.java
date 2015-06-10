package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import facade.AdministratorFacade;
import model.Administrator;


@ManagedBean
public class AdministratorController {

	private Administrator administrator;
	private Long id;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private String loginError;
	private String singUpError;
	@EJB
	private AdministratorFacade administratorFacade;

	/*public String createAdministrator(){
		try{
			this.administrator = this.administratorFacade.createAdministrator(name, lastname, email, password);
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("user", this.administrator);
			return "homeAdministrator";
		}catch(Exception e){
			this.setSingUpError("Email is not valid.");
		}return "login";
	}*/

	public String loginAdministrator(){
		try{
			this.administrator = this.administratorFacade.getAdministrator(email);
			if(this.administratorFacade.checkPwd(administrator, password)){
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getSessionMap().put("administrator", this.administrator);
				return "homeAdministrator";
			}this.setLoginError("Email o Password sbagliata");
		}catch(Exception e){
			this.setLoginError("Email o Password sbagliata");
		}return "loginAdministrator";
	}
	
	public String logoutAdministrator(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("administrator");
		return "login";
	}
	
	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginError() {
		return loginError;
	}

	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}

	public String getSingUpError() {
		return singUpError;
	}

	public void setSingUpError(String singUpError) {
		this.singUpError = singUpError;
	}

	public AdministratorFacade getAdministratorFacade() {
		return administratorFacade;
	}

	public void setAdministratorFacade(AdministratorFacade administratorFacade) {
		this.administratorFacade = administratorFacade;
	}



}
