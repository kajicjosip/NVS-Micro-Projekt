package at.htl.kaffeeladen.business;

import at.htl.kaffeeladen.entities.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by josipkajic on 30.01.2017.
 */
@Stateless
public class ProductFacade {

    @PersistenceContext
    EntityManager em;

    public void save(Product product){
        em.persist(product);
    }
    public List<Product> findAll(){
        return em.createQuery("select p from Product p").getResultList();
    }

    public Product findById(Integer id){
        return (Product)em.createQuery("select b from Product b where b.id = :ID").setParameter("ID", id).getSingleResult();
    }
}
