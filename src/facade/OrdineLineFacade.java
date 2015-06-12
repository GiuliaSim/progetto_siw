package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	public OrderLine createOrdineLine(Long idProduct, float price, Integer quantity){
		Product product = this.em.find(Product.class, idProduct);
		OrderLine ordineLine = new OrderLine();
		ordineLine.setPrice(price);
		ordineLine.setProduct(product);
		ordineLine.setQuantity(quantity);
		this.em.persist(ordineLine);
		return ordineLine;
	}
}
