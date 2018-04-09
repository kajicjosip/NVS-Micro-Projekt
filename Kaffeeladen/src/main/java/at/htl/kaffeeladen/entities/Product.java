package at.htl.kaffeeladen.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by josipkajic on 30.01.2017.
 */
@Entity
@Table(name = "KL_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    private Integer id;
    @Column(name = "P_NAME")
    private String name;
    @Column(name = "P_PRICE")
    private double price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PurchasedProduct> purchasedProducts = new LinkedList<>();

    public void addPurchasedProduct(PurchasedProduct purchasedProduct){
        purchasedProducts.add(purchasedProduct);
    }

    public Product(){
    }
    public Product(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<PurchasedProduct> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<PurchasedProduct> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
}
