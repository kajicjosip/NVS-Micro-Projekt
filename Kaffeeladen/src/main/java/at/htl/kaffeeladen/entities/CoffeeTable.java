package at.htl.kaffeeladen.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by josipkajic on 31.01.2017.
 */
@Entity
@Table(name = "KL_COFFEE_TABLE")
public class CoffeeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CT_ID")
    private Integer id;
    @Column(name = "CT_COFFEE_TABLE_NR")
    private int coffeeTableNr;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Bill> billsOfTable = new LinkedList<>();
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "W_ID")
    private Waiter waiter;

    public CoffeeTable() { }
    public CoffeeTable(Waiter waiter, int coffeeTableNr){
        this.waiter = waiter;
        this.coffeeTableNr = coffeeTableNr;
    }

    public void addBillsToTable(Bill bill)
    {
        billsOfTable.add(bill);
    }

    public CoffeeTable(int coffeeTableNr) {
        this();
        this.coffeeTableNr = coffeeTableNr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCoffeeTableNr() {
        return coffeeTableNr;
    }

    public void setCoffeeTableNr(int coffeeTableNr) {
        this.coffeeTableNr = coffeeTableNr;
    }

    public List<Bill> getBillsOfTable() {
        return billsOfTable;
    }

    public void setBillsOfTable(List<Bill> billsOfTable) {
        this.billsOfTable = billsOfTable;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
        waiter.addTable(this);
    }
}
