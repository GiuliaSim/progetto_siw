package model;

import javax.persistence.*;


@Entity
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Float price;

	@Column(nullable = false)
	private Integer quantity;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Product product;
	
	public OrderLine(){
		
	}

	public OrderLine(Float price, Integer quantity, Product product) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", price=" + price + ", quantity="
				+ quantity + ", product=" + product + "]";
	}

	
	
}
