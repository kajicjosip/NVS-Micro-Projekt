package at.htl.kaffeeladen.web;

import at.htl.kaffeeladen.business.*;
import at.htl.kaffeeladen.entities.*;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
public class MainController {

    @Inject
    TableFacade tableFacade;
    @Inject
    WaiterFacade waiterFacade;
    @Inject
    ProductFacade productFacade;
    @Inject
    BillFacade billFacade;
    @Inject
    PurchasedProductFacade purchasedProductFacade;

    private List<CoffeeTable> coffeeTables = new LinkedList<>();
    private List<Waiter> waiterList = new LinkedList<>();
    private List<Product> products = new LinkedList<>();
    private List<Bill> bills = new LinkedList<>();

    private Waiter newWaiter = new Waiter();
    private Product newProduct = new Product();
    private CoffeeTable newCoffeeTable = new CoffeeTable();
    private int newWaiterId;
    private Bill newBill = new Bill();
    private int newCoffeeTableId;
    private PurchasedProduct newPurchasedProduct = new PurchasedProduct();
    private int newProductId;

    private Bill selectedBill = null;

    @PostConstruct
    public void postConstruct(){
        coffeeTables = tableFacade.findAll();
        waiterList = waiterFacade.findAll();
        products = productFacade.findAll();
        bills = billFacade.findAll();
    }

    public List<CoffeeTable> getCoffeeTables() {
        return coffeeTables;
    }

    public void setCoffeeTables(List<CoffeeTable> coffeeTables) {
        this.coffeeTables = coffeeTables;
    }

    public List<Waiter> getWaiterList() {
        return waiterList;
    }

    public void setWaiterList(List<Waiter> waiterList) {
        this.waiterList = waiterList;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Waiter getNewWaiter() {
        return newWaiter;
    }

    public void setNewWaiter(Waiter newWaiter) {
        this.newWaiter = newWaiter;
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }

    public CoffeeTable getNewCoffeeTable() {
        return newCoffeeTable;
    }

    public void setNewCoffeeTable(CoffeeTable newCoffeeTable) {
        this.newCoffeeTable = newCoffeeTable;
    }

    public int getNewWaiterId() {
        return newWaiterId;
    }

    public void setNewWaiterId(int newWaiterId) {
        this.newWaiterId = newWaiterId;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Bill getNewBill() {
        return newBill;
    }

    public void setNewBill(Bill newBill) {
        this.newBill = newBill;
    }

    public int getNewCoffeeTableId() {
        return newCoffeeTableId;
    }

    public void setNewCoffeeTableId(int newCoffeeTableId) {
        this.newCoffeeTableId = newCoffeeTableId;
    }

    public void setSelectedBill(Bill selectedBill) {
        this.selectedBill = selectedBill;
    }

    public Bill getSelectedBill() {
        return selectedBill;
    }

    public PurchasedProduct getNewPurchasedProduct() {
        return newPurchasedProduct;
    }

    public void setNewPurchasedProduct(PurchasedProduct newPurchasedProduct) {
        this.newPurchasedProduct = newPurchasedProduct;
    }

    public int getNewProductId() {
        return newProductId;
    }

    public void setNewProductId(int newProductId) {
        this.newProductId = newProductId;
    }

    public void createNewWaiter(){
        waiterFacade.save(newWaiter);
        waiterList.add(newWaiter);
        RequestContext.getCurrentInstance().update("waiterList");
        RequestContext.getCurrentInstance().update("coffeeTableWaiter");

    }

    public void createNewProduct(){
        productFacade.save(newProduct);
        products.add(newProduct);
        RequestContext.getCurrentInstance().update("productList");
    }
    public void createNewCoffeeTable(){
        for(Waiter w: waiterList)
            if(w.getId()==newWaiterId)
                newCoffeeTable.setWaiter(w);
        tableFacade.updateSave(newCoffeeTable);
        coffeeTables.add(newCoffeeTable);
        RequestContext.getCurrentInstance().update("coffeeTableList");
    }
    public void createNewBill(){
        for(CoffeeTable ct: coffeeTables)
            if(ct.getId()==newCoffeeTableId)
                newBill.setCoffeeTable(ct);
        billFacade.save(newBill);
        bills.add(newBill);
        RequestContext.getCurrentInstance().update("billList");
    }
    public void createNewPurchasedProduct(){
        for(Product p:products)
            if(p.getId() == newProductId)
                newPurchasedProduct.setProduct(p);
        newPurchasedProduct.setBill(selectedBill);
        purchasedProductFacade.save(newPurchasedProduct);
        RequestContext.getCurrentInstance().update("selectedBill");
        RequestContext.getCurrentInstance().update("billList");
    }

}


