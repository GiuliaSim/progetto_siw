package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import facade.OrdineFacade;
import model.Order;
import model.OrderLine;
import model.User;

@ManagedBean
public class OrdineController {

	@EJB (beanName = "oFacade")
	private OrdineFacade ordineFacade;

	@ManagedProperty(value="#{param.id}")
	private Long id;

	@ManagedProperty(value="#{param.idProduct}")
	private Long idProduct;

	@ManagedProperty(value="#{param.idUser}")
	private Long idUser;

	private Date creationTime;
	private Date closingDate;
	private User user;
	private Order ordine;
	private List<OrderLine> orderLines;

	public String createOrdine(){
		this.ordine=this.ordineFacade.createOrdine(idUser);
		return "ordine";
	}

	public List<OrderLine> ListOrderLines(){
		this.orderLines = this.ordineFacade.listOrderLines(this.id);
		return this.orderLines;
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

}

