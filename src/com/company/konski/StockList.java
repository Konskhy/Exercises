package com.company.konski;

import java.util.*;

public class StockList {
    private Map <String,StockItem>list;
    public StockList(){
        this.list = new TreeMap<>();
    }
    public int addStock(StockItem item){
        if (item!=null){
            StockItem inStock = list.getOrDefault(item.getName(),item);
            if (inStock!=item){
                item.adjustStock(item.getStockQuantity());
            }
            list.put(inStock.getName(),inStock);
            return item.getStockQuantity();
        }
        return 0;
    }
    public int sellStock(StockItem item, int quantity){
        StockItem toSell = list.getOrDefault(item.getName(),null);
        if (toSell!=null && quantity>0) {
            if (toSell.getStockQuantity() >= quantity) {
                toSell.adjustStock(-quantity);
                return toSell.getStockQuantity();
            }
            System.out.println("Not enough " + toSell.getName() + " in stock");
            return 0;
        }return 0;
    }
    public int reserveStock(StockItem item, int quantity){
        StockItem toAdd = list.getOrDefault(item.getName(), null);
        if (toAdd!=null){
            if (toAdd.getStockQuantity()-toAdd.getReserved()>=quantity){
                toAdd.reserveItem(quantity);
                return quantity;
            }else System.out.println("Not enough "+toAdd.getName()+" in stock");
            return 0;
        }return 0;
    }

    public Map<String, StockItem> listItems() {
        return Collections.unmodifiableMap(list);
    }
    public StockItem getItem(String key){
        return list.get(key);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String,StockItem> item:list.entrySet()){
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice()*stockItem.getStockQuantity();
            s= s + stockItem.getName() + ". There are "+stockItem.getStockQuantity()+" in stock. Value of the items:";
            s= s+ String.format("%.2f",itemValue) + "\n";
            totalCost+=itemValue;
        }
        return s + "Total stock value: " + String.format("%.2f",totalCost);
    }
}
