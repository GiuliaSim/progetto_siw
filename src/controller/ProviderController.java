package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import facade.ProductFacade;
import facade.ProviderFacade;
import model.Address;
import model.Provider;


@ManagedBean
public class ProviderController {
	@EJB(beanName ="prFacade")
	private ProviderFacade providerFacade;
	
	@EJB(beanName ="pFacade")
	private ProductFacade productFacade;
	
	@ManagedProperty(value = "#{param.id}")
	private Long id;
	@ManagedProperty(value = "#{param.idProduct}")
	private Long idProduct;
	
	private Provider provider;
	private String name;
	private String phoneNumber;
	private String email;
	private String vatid;
	private List<Provider> providers;
	


	private Address address;
	private String street;
	private String city;
	private String country;
	private String state;
	private String zipcode;

	
	

	public String createProvider(){
		this.address=new Address(this.street, this.city,  this.state, this.zipcode, this.country);
		this.provider = this.providerFacade.createProvider(name, phoneNumber, email, vatid, address);
		return "providerAdministrator";
	}
	
	public String getProviderById(){
		this.provider = this.providerFacade.getProvider(this.id);
		return "providerAdministrator";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVatid() {
		return vatid;
	}

	public void setVatid(String vatid) {
		this.vatid = vatid;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ProviderFacade getProviderFacade() {
		return providerFacade;
	}

	public void setProviderFacade(ProviderFacade providerFacade) {
		this.providerFacade = providerFacade;
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

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
}
