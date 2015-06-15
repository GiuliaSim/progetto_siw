package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import facade.OrdineFacade;
import facade.ProductFacade;
import model.Order;
import model.OrderLine;
import model.Product;
import model.User;

@ManagedBean
public class OrdineController {

	@EJB (beanName = "oFacade")
	private OrdineFacade ordineFacade;

	@EJB (beanName = "pFacade")
	private ProductFacade productFacade;


	@ManagedProperty(value="#{param.idProduct}")
	private Long idProduct;

	@ManagedProperty(value="#{param.price}")
	private Float price;
	
	@ManagedProperty(value="#{user}")
	private User user;

	@ManagedProperty(value="#{currentOrder}")
	private Order ordine;

	private Long id;
	private Date creationTime;
	private Date closingDate;
	private List<OrderLine> orderLines;

	private OrderLine orderLine;
	private Integer quantity;
	private String error;

	public String createOrdine(){
		FacesContext context = FacesContext.getCurrentInstance();
		User user = (User) context.getExternalContext().getSessionMap().get("user");
		this.ordine=this.ordineFacade.createOrdine(user);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentOrder", this.ordine);

		this.orderLines = this.ordineFacade.listOrderLines(this.ordine.getId());
		return "ordine";
	}

	public String createOrdineLine(){
		Product product = this.productFacade.getProduct(this.idProduct);
		if(this.quantity <= product.getQuantityAvailable()){
			this.orderLine = this.ordineFacade.createOrdineLine(product, this.price, this.quantity);
		}else{ this.setError("Quantità non disponibile");}
		this.orderLines = this.ordineFacade.listOrderLines(this.ordine.getId());
		return "ordine";
	}
	public List<OrderLine> listOrderLines(){
		this.orderLines = this.ordineFacade.listOrderLines(this.ordine.getId());
		return this.orderLines;
	}
	
	public String closeOrder(){
		this.closingDate = new Date();
		this.ordine = this.ordineFacade.closeOrder(this.closingDate);
		return "homeUser";
	}

	public OrdineFacade getOrdineFacade() {
		return ordineFacade;
	}

	public void setOrdineFacade(OrdineFacade ordineFacade) {
		this.ordineFacade = ordineFacade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrdine() {
		return ordine;
	}

	public void setOrdine(Order ordine) {
		this.ordine = ordine;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductFacade getProductFacade() {
		return productFacade;
	}

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}

