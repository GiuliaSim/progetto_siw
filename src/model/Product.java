package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private Float price;
	
	@Column(nullable=true)
	private String description;
	@Column(nullable=false)
	private String code;
	@ManyToMany(cascade= {CascadeType.PERSIST})
	private List<Provider> providers;
	
	@Column
	private Integer quantityAvailable;

	public Product() {
	}

	public Product(String name, Float price, String description, String code, Integer quantityAvailable) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.code = code;
		this.quantityAvailable = quantityAvailable;
		this.providers = new ArrayList<Provider>();
	}

	public Long getId() {
		return id;
	}
	
	
	public Integer getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(Integer quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public boolean equals(Object obj) {
		Product product = (Product)obj;
		return this.getCode().equals(product.getCode());
	}

	public int hashCode() {
		return this.code.hashCode();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", code=" + code
				+ ", providers=" + providers + ", quantitaMagazzino="
				+ quantityAvailable + "]";
	}

	
}