package com.company.konski;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
    private Map <String,StockItem>list;
    public StockList(){
        this.list = new HashMap<>();
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
        if (toSell!=null && toSell.getStockQuantity()>=quantity && quantity>0){
            toSell.adjustStock(-quantity);
            return toSell.getStockQuantity();
        } return 0;
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
            s= s + stockItem + ". There are "+stockItem.getStockQuantity()+" in stock. Value of the items:";
            s= s+ itemValue + "\n";
            totalCost+=itemValue;
        }
        return s + "Total stock value: " + totalCost;
    }
}
