package at.htl.kaffeeladen.business;

import at.htl.kaffeeladen.entities.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by josipkajic on 30.01.2017.
 */
@Startup
@Singleton
public class InitBean {

    @Inject
    ProductFacade productFacade;
    @Inject
    BillFacade billFacade;
    @Inject
    TableFacade tableFacade;
    @Inject
    WaiterFacade waiterFacade;
    @Inject
    PurchasedProductFacade purchasedProductFacade;

    @PostConstruct
    public void init(){
        Waiter waiter1 = new Waiter("Karl", 1000);
        Waiter waiter2 = new Waiter("Gustav", 1200);
        waiterFacade.save(waiter1);
        waiterFacade.save(waiter2);
        CoffeeTable coffeeTable = new CoffeeTable(waiter1,10);
        tableFacade.save(coffeeTable);
        Product product1 = new Product("Espresso",3);
        Product product2 = new Product("Chocolate",4);
        productFacade.save(product1);
        productFacade.save(product2);

        Bill bill = new Bill("123",coffeeTable);
        billFacade.save(bill);
        PurchasedProduct purchasedProduct = new PurchasedProduct(2,product1,bill);
        purchasedProductFacade.save(purchasedProduct);
    }
}
