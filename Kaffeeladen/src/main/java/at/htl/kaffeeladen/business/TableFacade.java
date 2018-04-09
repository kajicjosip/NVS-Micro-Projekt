package at.htl.kaffeeladen.business;

import at.htl.kaffeeladen.entities.CoffeeTable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by josipkajic on 30.01.2017.
 */
@Stateless
public class TableFacade {

    @PersistenceContext
    EntityManager em;

    public void save(CoffeeTable coffeeTable){
        em.persist(coffeeTable);
    }
    public void updateSave(CoffeeTable coffeeTable){
        em.merge(coffeeTable);
    }

    public List<CoffeeTable> findAll(){
        return em.createQuery("select t from CoffeeTable t").getResultList();
    }

    public CoffeeTable findById(Integer id){
        return (CoffeeTable)em.createQuery("select t from CoffeeTable t where t.id = :ID").setParameter("ID", id).getSingleResult();
    }

}
