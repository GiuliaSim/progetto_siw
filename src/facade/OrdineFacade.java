package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Order;
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

}
