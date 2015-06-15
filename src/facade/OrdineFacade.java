package facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Order;
import model.OrderLine;
import model.Product;
import model.User;

@Stateless(name="oFacade")
public class OrdineFacade {

	@PersistenceContext(unitName = "persistence-unit")
	private EntityManager em;

	public OrdineFacade(){

	}

	public OrdineFacade(EntityManager em){
		super();
		this.em=em;
	}
	public Order createOrdine(User user) {
		
		Order ordine = new Order();
		ordine.setUser(user);
		this.em.persist(ordine);
		return ordine;
	}

	public List<OrderLine> listOrderLines(Long id) {
		TypedQuery<OrderLine> orderLines = this.em.createQuery("SELECT ol FROM Order o JOIN o.orderLines ol WHERE o.id =: id", OrderLine.class);
		orderLines.setParameter("id", id);

		return orderLines.getResultList();
	}

	public OrderLine createOrdineLine(Product product, Float price, Integer quantity) {
		FacesContext context = FacesContext.getCurrentInstance();
		Order order = (Order) context.getExternalContext().getSessionMap().get("currentOrder");


		OrderLine orderLine = new OrderLine();

		orderLine.setProduct(product);
		orderLine.setPrice(price);
		orderLine.setQuantity(quantity);

		product.setQuantityAvailable(product.getQuantityAvailable()-quantity);

		order.getOrderLines().add(orderLine);
		this.em.persist(orderLine);
		this.em.merge(product);
		return orderLine;
	}

	public Order closeOrder(Date closingDate) {
		FacesContext context = FacesContext.getCurrentInstance();
		Order order = (Order) context.getExternalContext().getSessionMap().get("currentOrder");
		order.setClosingDate(closingDate);
		this.em.merge(order);
		context.getExternalContext().getSessionMap().remove("currentOrder");
		return order;
	}
}
