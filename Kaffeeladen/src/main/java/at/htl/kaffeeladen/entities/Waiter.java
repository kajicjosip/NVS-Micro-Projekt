package at.htl.kaffeeladen.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by josipkajic on 30.01.2017.
 */
@Entity
@Table(name = "KL_WAITER")
public class Waiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "W_ID")
    private Integer id;
    @Column(name = "W_NAME")
    private String name;
    @Column(name = "W_SALARY")
    private double salary;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "waiter")
    private List<CoffeeTable> coffeeTableList = new LinkedList<>();

    public void addTable(CoffeeTable table)
    {
        if(coffeeTableList==null)
            coffeeTableList = new LinkedList<>();
        coffeeTableList.add(table);
    }

    public Waiter(){}

    public Waiter(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public List<CoffeeTable> getCoffeeTableList() {
        return coffeeTableList;
    }

    public void setCoffeeTableList(List<CoffeeTable> coffeeTableList) {
        this.coffeeTableList = coffeeTableList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
