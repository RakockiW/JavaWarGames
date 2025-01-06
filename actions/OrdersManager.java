package actions;

import java.util.ArrayList;

public class OrdersManager {
    public ArrayList<Order> orders = new ArrayList<Order>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void executeOrders() {
        for (Order order : orders) {
            order.execute();
        }
    }   

    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
