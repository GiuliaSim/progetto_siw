package facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Product;


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
		Product product = em.find(Product.class, id);
		return product;
	}
	
	public List<Product> getAllProducts() {
		//TODO
		//return new LinkedList<Product>(products.values());
		Query allProduct = em.createQuery("SELECT p FROM Product p");
		return allProduct.getResultList();
	}

	public void updateProduct(Product product) {
		//TODO
		//products.put(product.getId(), product);
	}

	public void deleteProduct(Long id) {
		Product product = em.find(Product.class, id);
		em.remove(product);
		//TODO
		//products.remove(id);
			
	}
}
