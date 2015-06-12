package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Order;
import model.OrderLine;
import model.Product;

@Stateless(name = "olFacade")
public class OrdineLineFacade {

	@PersistenceContext(unitName = "persistence-unit")
	private EntityManager em;
	
	public OrdineLineFacade(){
		
	}
	public OrdineLineFacade(EntityManager em){
		super();
		this.em=em;
	}
	
	public OrderLine createOrdineLine(Long idProduct, Float price, Integer quantity, Long idOrder){
		Product product = this.em.find(Product.class,idProduct );
		Order order = this.em.find(Order.class, idOrder);
		OrderLine ordineLine = new OrderLine();
		ordineLine.setPrice(price);
		ordineLine.setProduct(product);
		ordineLine.setQuantity(quantity);
		order.getOrderLines().add(ordineLine);
		this.em.persist(ordineLine);
		return ordineLine;
	}
}
