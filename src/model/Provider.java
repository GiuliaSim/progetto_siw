package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Provider {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String phoneNumber;
	private String email;
	private String vatid;
	
	@OneToOne
	@Column(name="address_id")
	private Address address;
	
	@ManyToMany(mappedBy = "providers",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Product> products;
	

	public Provider(){
	}

	public Provider(String name, String phoneNumber, String email,
			String vatid, Address address, List<Product> products) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.vatid = vatid;
		this.address = address;
		this.products = products;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "Provider [id=" + id + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", vatid=" + vatid
				+ ", address=" + address + ", products=" + products + "]";
	}
}
