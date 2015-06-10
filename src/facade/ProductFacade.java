package facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Product;
import model.Provider;


@Stateless(name="pFacade")
public class ProductFacade {
	
	@PersistenceContext(unitName="persistence-unit")
	private EntityManager em;
	
	public ProductFacade(EntityManager em){
		this.em=em;
	}
	public ProductFacade(){}

	
	public Product createProduct(String name, Float price, String description,String code ) {
			Product product = new Product();
			product.setCode(code);
			product.setDescription(description);
			product.setName(name);
			product.setPrice(price);
			try {
				this.em.persist(product);
				return product;
			} catch (Exception e){
			return null;
			}
	}

	public Product getProduct(Long id) {
		Product product = this.em.find(Product.class, id);
		return product;
	}
	
	public List<Product> getAllProducts() {
		TypedQuery<Product> allProduct = this.em.createQuery("SELECT p FROM Product p", Product.class);
		return allProduct.getResultList();
	}

	public void updateProduct(Product product) {
		//TODO
		//products.put(product.getId(), product);
	}

	public void deleteProduct(Long id) {
		Product product = this.em.find(Product.class, id);
		this.em.remove(product);
			
	}
	
	public List<Provider> getAllProviders(){
		TypedQuery<Provider> allProvider = this.em.createQuery("SELECT p FROM Provider p", Provider.class);
		return allProvider.getResultList();
	}
	
	public Provider addProvider(Long idProduct, Long idProvider){
		Product product = this.em.find(Product.class, idProduct);
		Provider provider = this.em.find(Provider.class, idProvider);
		product.getProviders().add(provider);
		return provider;
	}
	
	public List<Provider> getProvidersByProduct(Long id){
		TypedQuery<Provider> providers = this.em.createQuery("SELECT p FROM Provider p WHERE p.products.id =: id", Provider.class).setParameter("id", id);
		return providers.getResultList();
	}
}
