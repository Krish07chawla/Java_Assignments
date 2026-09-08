package food.main;

import food.model.FoodOrder;
import food.model.PremiumOrder;
import food.model.RegularOrder;
import food.utility.OrderUtility;

public class Main {
    public static void main(String[] args) {
        FoodOrder[] orders = new FoodOrder[6];
        orders[0] = new RegularOrder(101, "Asha Kumar", 450.0);
        orders[1] = new PremiumOrder(102, "Rohit Singh", 780.0);
        orders[2] = new RegularOrder(103, "Priya Mehta", 320.0);
        orders[3] = new PremiumOrder(104, "Sonia Patel", 1500.0);
        orders[4] = new RegularOrder(105, "Rahul Sharma", 620.0);
        orders[5] = new PremiumOrder(106, "Neha Gupta", 980.0);

        System.out.println("Restaurant: " + FoodOrder.restaurantName);
        for (FoodOrder order : orders) {
            System.out.println(OrderUtility.generateOrderSummary(order));
        }

        FoodOrder.displayTotalOrders();
    }
}
