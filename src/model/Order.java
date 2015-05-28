package model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date closingDate;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date evasionDate;
	
	@ManyToOne
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<OrderLine> orderLines;
	
	public Order(){
	}

	public Order(Date creationDate, Date closingDate, Date evasionDate,
			User user, List<OrderLine> orderLines) {
		super();
		this.creationDate = creationDate;
		this.closingDate = closingDate;
		this.evasionDate = evasionDate;
		this.user = user;
		this.orderLines = orderLines;
	}

	public Long getId() {
		return id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Date getEvasionDate() {
		return evasionDate;
	}

	public void setEvasionDate(Date evasionDate) {
		this.evasionDate = evasionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", creationDate=" + creationDate
				+ ", closingDate=" + closingDate + ", evasionDate="
				+ evasionDate + ", user=" + user + ", orderLines=" + orderLines
				+ "]";
	}
	
}
