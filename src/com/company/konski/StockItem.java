package com.company.konski;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int stockQuantity;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.stockQuantity=0;
        this.reserved = 0;
    }

    public StockItem(String name, double price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        reserved=0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
    public void reserveItem(int quantity){
        if (getReserved()+quantity>=0)
        this.reserved+=quantity;
        else System.out.println("There are only "+getReserved()+" items of that type in the basket");
    }


    public int getReserved() {
        return reserved;
    }

    public void setPrice(double price) {
        if (price >=0) this.price = price;
    }

    public void adjustStock(int quantity){
        int stock = stockQuantity+quantity;
        if (stock>=0) this.stockQuantity=stock;
    }

    @Override
    public int compareTo(StockItem o) {
        if (this==o)
        return 0;
        if (o!=null)
        return this.getName().compareTo(o.getName());
        throw new NullPointerException();
    }
    @Override
    public boolean equals (Object o){
        if (this==o) return true;
        if (o==null || (o.getClass()!=this.getClass()))return false;
        String  name = ((StockItem)o).getName();
        return this.getName().equals(name);
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode()+31;
    }
}
