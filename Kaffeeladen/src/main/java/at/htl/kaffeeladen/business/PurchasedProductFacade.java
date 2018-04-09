package at.htl.kaffeeladen.business;

import at.htl.kaffeeladen.entities.PurchasedProduct;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PurchasedProductFacade {

    @PersistenceContext
    EntityManager entityManager;

    public void save(PurchasedProduct purchasedProduct){
        entityManager.persist(purchasedProduct);
    }

    public List<PurchasedProduct> findAll(){
        return entityManager.createQuery("select p from PurchasedProduct p").getResultList();
    }
}
