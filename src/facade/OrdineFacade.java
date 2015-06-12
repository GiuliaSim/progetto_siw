package facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Order;
import model.OrderLine;
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
	public Order createOrdine(Long idUser) {
		User user = this.em.find(User.class, idUser);
		Order ordine = new Order();
		ordine.setUser(user);
		this.em.persist(ordine);
		return ordine;
	}

	public List<OrderLine> listOrderLines(Long id) {
		TypedQuery<OrderLine> orderLines = this.em.createQuery("SELECT ol FROM OrderLine ol WHERE ol.id =: id", OrderLine.class);
		orderLines.setParameter("id", id);
		return orderLines.getResultList();
	}

}
