package at.htl.kaffeeladen.business;

import at.htl.kaffeeladen.entities.Waiter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by josipkajic on 30.01.2017.
 */
@Stateless
public class WaiterFacade {

    @PersistenceContext
    EntityManager em;

    public void save(Waiter waiter){
        em.persist(waiter);
    }

    public List<Waiter> findAll(){
        return em.createQuery("select w from Waiter w").getResultList();
    }

    public Waiter findById(Integer id){
        return (Waiter) em.createQuery("select w from Waiter w where w.id = :ID").setParameter("ID", id).getSingleResult();
    }

}
