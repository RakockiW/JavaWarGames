package army;


import java.util.ArrayList;

import actions.Order;
import actions.OrdersManager;

public class General {
    private int gold;
    private Army army;
    private OrdersManager orders = new OrdersManager();
    private String name;

    public General(String name,int gold, Army army) {
        this.name = name;
        this.gold = gold;
        this.army = army;
    }

    public Army getArmy() {
        return army;
    }

    public int getGold() {    
        return gold;
    }

    public void addGold(int amount) {
        this.gold += amount;
    }

    public void payGold(int amount) {
        this.gold -= amount;
    }

    public void executeOrders() {
        orders.executeOrders();
    }

    public void addOrder(Order order) {
        orders.addOrder(order);
    }

    public void removeOrder(Order order) {
        orders.orders.remove(order);
    }

    public ArrayList<Order> getOrders() {
        return orders.orders;
    }

    public String getName() {
        return name;
    }


}
