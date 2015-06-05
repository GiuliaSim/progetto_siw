package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import facade.UserFacade;
import model.Address;
import model.Order;
import model.User;

@ManagedBean
public class UserController {

	private Long id;
	private User user;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private Date dateOfBirth;
	private Date registrationDate;
	private List<Order> orders;
	
	private Address address;
	private String street;
	private String city;
	private String country;
	private String state;
	private String zipcode;
	
	@EJB
	private UserFacade userFacade;
	
	private String loginError;
	private String signUpError;
	
	public String createUser(){
		this.address=new Address( this.street, this.city,  this.state, this.zipcode, this.country);
		try{
			this.user = this.userFacade.createUser(name, lastname, email, password, dateOfBirth, address);
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("user", this.user);
			return "homeUser";
		}catch(Exception e){
			this.setSignUpError("Email is not valid");
		}
		return "login";
	}

	public String loginUser(){
		try{
			this.user = this.userFacade.getUser(email);
			if(this.userFacade.checkPwd(user,password)){
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getSessionMap().put("user", this.user);
				return "homeUser";
			}
			this.setLoginError("Wrong Password or Email!");
		}
		catch(Exception e){
			this.setLoginError("Wrong Password or email!");
		}
		return "login";
	}
	
	public String logoutUser(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
		return "login";
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}



	public String getLoginError() {
		return loginError;
	}



	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}



	public String getSignUpError() {
		return signUpError;
	}



	public void setSignUpError(String signUpError) {
		this.signUpError = signUpError;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



}
