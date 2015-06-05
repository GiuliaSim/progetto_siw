package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Product;
import facade.ProductFacade;

@ManagedBean
public class ProductController {

	//@ManagedProperty(value = "#{param.id}")
	private Long id;
	
	private String name;
	private Float price;
	private String description;
	private String code;
	private Product product;
	private List<Product> products;
	@EJB
	private ProductFacade productFacade;
	
	public String createProduct(){

		this.product = this.productFacade.createProduct(name,price, description,code);
		return "product";
	}

	public String deleteProduct(){
		this.productFacade.deleteProduct(id);
		this.products = this.productFacade.getAllProducts();
		return "productsAdministrator";

	}
	
	public String listProduct(){
		this.products = this.productFacade.getAllProducts();
		return "products";
	}
	public String listProductAdministrator(){
		this.products = this.productFacade.getAllProducts();
		return "productsAdministrator";
	}

	public ProductFacade getProductFacade() {
		return productFacade;
	}

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getId() {
		return id;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> list) {
		this.products = list;
	}


}
