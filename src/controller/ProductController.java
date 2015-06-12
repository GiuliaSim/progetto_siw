package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import model.Product;
import model.Provider;
import facade.ProductFacade;

@ManagedBean
public class ProductController {
	@EJB(beanName ="pFacade")
	private ProductFacade productFacade;
	
	@ManagedProperty(value = "#{param.id}")
	private Long id;
	
	@ManagedProperty(value = "#{param.idProvider}")
	private Long idProvider;
	
	@ManagedProperty(value="#{param.idOrder}")
	private Long idOrder;
	
	private String name;
	private Float price;
	private String description;
	private String code;
	private Product product;
	private List<Product> products;
	private List<Provider> providers;
	private List<Provider> providersByProduct;
	private Provider provider;

	
	
	public String createProduct(){
		this.product = this.productFacade.createProduct(name,price, description,code);
		this.providersByProduct = this.productFacade.getProvidersByProduct(this.id);
		//FacesContext context = FacesContext.getCurrentInstance();
		//context.getExternalContext().getSessionMap().put("product", this.product);
		return "productAdministrator";
	}

	public String deleteProduct(){
		this.productFacade.deleteProduct(this.id);
		this.products = this.productFacade.getAllProducts();
		return "productsAdministrator";

	}
	
	public String listProduct(){
		this.products = this.productFacade.getAllProducts();
		return "products";
	}
	public String listProductForOrder(){
		this.products = this.productFacade.getAllProducts();
		return "catalog";
	}
	public String listProductAdministrator(){
		this.products = this.productFacade.getAllProducts();
		return "productsAdministrator";
	}
	

	public String listProvider(){
		this.providers = this.productFacade.getAllProviders();
		return "providersAdministrator";
	}
	
	public String addProvider(){
		this.provider = this.productFacade.addProvider(this.id, this.idProvider);
		this.product = this.productFacade.getProduct(this.id);
		this.products = this.productFacade.getAllProducts();
		this.providersByProduct = this.productFacade.getProvidersByProduct(this.id);
		return "productAdministrator";
	}
	
	public String getProductById(){
		this.product = this.productFacade.getProduct(this.id);
		this.providersByProduct = this.productFacade.getProvidersByProduct(this.id);
		return "productAdministrator";
	}
	public String getProductByIdForOrder(){
		this.product = this.productFacade.getProduct(this.id);
		return "productForOrder";
	}
	
	
	public String getProductByIdUser(){
		this.product = this.productFacade.getProduct(this.id);
		this.providersByProduct = this.productFacade.getProvidersByProduct(this.id);
		return "product";
	}
	
	public String listProvidersByProduct(){
		this.providersByProduct = this.productFacade.getProvidersByProduct(this.id);
		return "providersAdministrator";
	}

	public ProductFacade getProductFacade() {
		return productFacade;
	}

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> list) {
		this.products = list;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public Long getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(Long idProvider) {
		this.idProvider = idProvider;
	}

	public List<Provider> getProvidersByProduct() {
		return providersByProduct;
	}

	public void setProvidersByProduct(List<Provider> providersByProduct) {
		this.providersByProduct = providersByProduct;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}
}
