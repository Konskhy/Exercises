package com.company.konski;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("Cheese",2.30,150);
        stockList.addStock(temp);
        temp = new StockItem("Bread",1.20,100);
        stockList.addStock(temp);
        temp = new StockItem("Juice",2.50,50);
        stockList.addStock(temp);
        temp = new StockItem("Beer",2.20,200);
        stockList.addStock(temp);
        temp = new StockItem("Vodka",17.90,80);
        stockList.addStock(temp);
        temp = new StockItem("Smokes",15.50,400);
        stockList.addStock(temp);
        temp = new StockItem("Ham",7.49,55);
        stockList.addStock(temp);
        temp = new StockItem("Chocolate",10.50);
        stockList.addStock(temp);
        System.out.println(stockList);
        Basket timsBasket = new Basket("Tim");
        addToBasket(timsBasket,"Smokes",200);
        addToBasket(timsBasket,"Smokes",100);
        addToBasket(timsBasket,"Smokes",200);
        addToBasket(timsBasket,"Vodka",2);
        addToBasket(timsBasket,"Juice",4);
        System.out.println(timsBasket);
        removeFromBasket(timsBasket,"Ham",5);
        removeFromBasket(timsBasket,"Smokes",50);
        removeFromBasket(timsBasket,"Juice",4);
        removeFromBasket(timsBasket,"Vodka",5);
        removeFromBasket(timsBasket,"Vodka",1);
        removeFromBasket(timsBasket,"Hummus",5);
        System.out.println(timsBasket);
        timsBasket.checkout();
        System.out.println(stockList);
        System.out.println(timsBasket);

    }
    public static int addToBasket(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.getItem(item);
        if (stockItem==null){
            System.out.println("We don't sell "+ item);
            return 0;
        } else if (stockList.reserveStock(stockItem,quantity)!=0){
            basket.addToBasket(stockItem,quantity);
            System.out.println(quantity+ " x "+stockItem.getName()+" added to basket");
            return quantity;
        }
        return 0;
    }
    public static int removeFromBasket(Basket basket,String item, int quantity) {
        StockItem stockItem = stockList.getItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        int basketQuantity = basket.itemsInBasket().getOrDefault(stockItem, 0);
        if (basketQuantity <= 0) {
            System.out.println("No " + item + " in the basket");
            return 0;
        }   else if (basketQuantity-quantity<0){
            System.out.println("There are only "+ basketQuantity +" "+item+"  in the basket");
        } else if (stockList.reserveStock(stockItem, -quantity)!= 0) {
            basket.addToBasket(stockItem, -quantity);
            System.out.println(quantity + " x " + stockItem.getName() + " removed from basket");
            return quantity;
        }
        return 0;
    }
}
