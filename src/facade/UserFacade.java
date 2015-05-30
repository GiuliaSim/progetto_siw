package facade;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Address;
import model.User;


@Stateless(name="uFacade")
public class UserFacade {

	@PersistenceContext(unitName="persistence-unit")
	private EntityManager em;

	public UserFacade(){

	}

	public UserFacade(EntityManager em) {
		super();
		this.em = em;
	}

	public User createUser(String name, String lastname, String email,String password, Date dateOfBirth,Address address) {
		User user = new User();
		user.setName(name);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setDateOfBirth(dateOfBirth);
		user.setAddress(address);
		try {
			this.em.persist(user);
			return user;
		} catch (Exception e){
			return null;
		}
	}

	public User getUser(String email){
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email =:email");
		query.setParameter("email", email);
		return (User)query.getSingleResult();
	}


	public boolean checkPwd(User user, String password) {
		return user.getPassword().equals(password);
	}


}
