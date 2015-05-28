package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Administrator;


@Stateless(name="aFacade")
public class AdministratorFacade {
	
	@PersistenceContext(unitName="persistence-unit")
	private EntityManager em;
	
	public AdministratorFacade(){
		
	}

	public AdministratorFacade(EntityManager em) {
		super();
		this.em = em;
	}
	
	public Administrator createAdministrator(String name, String lastname, String email, String password){
		Administrator administrator = new Administrator();
		administrator.setName(name);
		administrator.setLastname(lastname);
		administrator.setEmail(email);
		administrator.setPassword(password);
		try{
			this.em.persist(administrator);
			return administrator;
		}catch(Exception e){
			return null;
		}
	}
	
	public Administrator getAdministrator(String email){
		Query query = em.createQuery("SELECT a FROM Administrator a WHERE a.email =:email");
		query.setParameter("email",email);
		return (Administrator)query.getSingleResult();
	}
	
	public boolean checkPwd(Administrator administrator, String password){
		return administrator.getPassword().equals(password);
	}

}
