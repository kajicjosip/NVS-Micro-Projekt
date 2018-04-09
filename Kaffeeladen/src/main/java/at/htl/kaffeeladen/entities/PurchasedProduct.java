package at.htl.kaffeeladen.entities;

import javax.persistence.*;

@Entity
@Table(name = "KL_PURCHASED_PRODUCT")
public class PurchasedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PP_ID")
    private int id;

    @Column(name = "PP_AMOUNT")
    private int amount;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "BILL_B_ID")
    private Bill bill;

    public PurchasedProduct() {
    }

    public PurchasedProduct(int amount, Product product, Bill bill) {
        this.amount = amount;
        this.product = product;
        this.bill = bill;
        bill.addProduct(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
        bill.addProduct(this);
    }
}
