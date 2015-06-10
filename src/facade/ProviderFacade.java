package facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Address;
import model.Product;
import model.Provider;


@Stateless(name="prFacade")
public class ProviderFacade {
	
	@PersistenceContext(unitName="persistence-unit")
	private EntityManager em;
	
	public ProviderFacade(){
		
	}
	
	public ProviderFacade(EntityManager em){
		super();
		this.em = em;
	}
	
	public Provider createProvider(String name, String phoneNumber, String email, String vatid, Address address){
		Provider provider = new Provider();
		provider.setName(name);
		provider.setPhoneNumber(phoneNumber);
		provider.setEmail(email);
		provider.setVatid(vatid);
		provider.setAddress(address);
		try{
			this.em.persist(provider);
			return provider;
		}catch(Exception e){
			return null;
		}
	}
	
	public Provider getProvider(Long id){
		Provider provider = this.em.find(Provider.class, id);
		return provider;
	}
}
