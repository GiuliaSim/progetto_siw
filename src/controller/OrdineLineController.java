package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import facade.OrdineLineFacade;
import model.OrderLine;

@ManagedBean
public class OrdineLineController {
	
	@EJB(beanName = "olFacade")
	private OrdineLineFacade ordineLineFacade;
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	@ManagedProperty(value="#{param.idProduct}")
	private Long idProduct;
	
	@ManagedProperty(value = "#{param.idOrdine}")
	private Long idOrdine;
	
	private OrderLine ordineLine;
	private Float price;
	private Integer quantity;
	
	public String createOrdineLine(){
		this.ordineLine = this.ordineLineFacade.createOrdineLine(this.idProduct,this.price,this.quantity);
		return "ordine";
	}

	public OrdineLineFacade getOrdineLineFacade() {
		return ordineLineFacade;
	}

	public void setOrdineLineFacade(OrdineLineFacade ordineLineFacade) {
		this.ordineLineFacade = ordineLineFacade;
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

	public Long getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Long idOrdine) {
		this.idOrdine = idOrdine;
	}

	public OrderLine getOrdineLine() {
		return ordineLine;
	}

	public void setOrdineLine(OrderLine ordineLine) {
		this.ordineLine = ordineLine;
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

}
