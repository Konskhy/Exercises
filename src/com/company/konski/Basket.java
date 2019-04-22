package com.company.konski;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    private Map <StockItem,Integer> basketList;
    private final String name;
    public Basket(String name){
        this.name=name;
        this.basketList = new LinkedHashMap<>();
    }
    public  void checkout(){
        for (Map.Entry<StockItem,Integer> item:basketList.entrySet()){
            int toRemove=item.getValue();
            item.getKey().reserveItem(-toRemove);
            item.getKey().adjustStock(-toRemove);
        }
        basketList.clear();
    }
    public int addToBasket(StockItem item, int quantity) {

        if (item != null) {
            int inBasket = basketList.getOrDefault(item, 0);
            if (quantity >= 0) {
                quantity += inBasket;
                basketList.put(item, quantity);
                return quantity;
            }
                quantity += inBasket;
            if (quantity!=0) {
                basketList.replace(item, quantity);
                return quantity;
            } else basketList.remove(item);
        }return 0;
    }
    public Map<StockItem,Integer> itemsInBasket(){
        return Collections.unmodifiableMap(basketList);
    }
    @Override
    public String toString() {
        if (!basketList.isEmpty()) {
            String s = "Shopping basket " + name + " contains " + basketList.size() + " items \n";
            double totalCost = 0.0;
            for (Map.Entry<StockItem, Integer> entry : basketList.entrySet()) {
                s = s + entry.getKey().getName() + ". " + entry.getValue() + " in basket \n";
                totalCost += entry.getKey().getPrice() * entry.getValue();
            }
            return s + "Total cost: " + totalCost;
        } else return "Shopping basket is empty";
    }
}
