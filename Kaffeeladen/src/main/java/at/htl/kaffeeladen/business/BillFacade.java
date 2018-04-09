package at.htl.kaffeeladen.business;

import at.htl.kaffeeladen.entities.Bill;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by josipkajic on 30.01.2017.
 */
@Stateless
public class BillFacade {

    @PersistenceContext
    EntityManager em;

    public void save(Bill bill){
        em.persist(bill);
    }

    public List<Bill> findAll(){
        return em.createQuery("select b from Bill b").getResultList();
    }

    public Bill findById(Integer id){
        return (Bill)em.createQuery("select b from Bill b where b.id = :ID").setParameter("ID", id).getSingleResult();
    }
}
