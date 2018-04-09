package at.htl.kaffeeladen.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by josipkajic on 30.01.2017.
 */
@Entity
@Table(name = "KL_BILL")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "B_ID")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bill")
    private List<PurchasedProduct> purchasedProducts = new LinkedList<>();


    @ManyToOne
    private CoffeeTable coffeeTable;
    @Column(name = "B_NUMBER")
    private String billNumber;

    public void addProduct(PurchasedProduct purchasedProduct) {
        purchasedProducts.add(purchasedProduct);
    }

    public Bill() {

    }

    public Bill(String billNumber, CoffeeTable coffeeTable) {
        this.billNumber = billNumber;
        this.coffeeTable = coffeeTable;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PurchasedProduct> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<PurchasedProduct> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public CoffeeTable getCoffeeTable() {
        return coffeeTable;
    }

    public void setCoffeeTable(CoffeeTable coffeeTable) {
        this.coffeeTable = coffeeTable;
    }

    public double getCosts() {
        double costs = 0;
        for (PurchasedProduct purchasedProduct : purchasedProducts)
            costs += purchasedProduct.getAmount() * purchasedProduct.getProduct().getPrice();
        return costs;
    }
}
