package model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String lastname;
	
	@Column(nullable=false, unique = true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date registrationDate;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Order> orders;
	
	@OneToOne
	private Address address;
	
	public User(){
		
	}

	public User(String name, String lastname, String email, String password,
			Date dateOfBirth, Date registrationDate, List<Order> orders,
			Address address) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.orders = orders;
		this.address = address;
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
}
