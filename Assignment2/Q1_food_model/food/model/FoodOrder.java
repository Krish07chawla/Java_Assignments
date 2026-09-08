package food.model;

import food.utility.OrderUtility;

public abstract class FoodOrder {
    private int orderId;
    private String customerName;
    private double amount;
    public static String restaurantName = "Food Delivery Express";
    private static int totalOrders = 0;

    protected FoodOrder(int orderId, String customerName, double amount) {
        setOrderId(orderId);
        setCustomerName(customerName);
        setAmount(amount);
        totalOrders++;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (!OrderUtility.validateCustomerName(customerName)) {
            throw new IllegalArgumentException("Invalid customer name. Name should contain only letters and spaces and be at least 3 characters long.");
        }
        this.customerName = customerName.trim();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (!OrderUtility.validateAmount(amount)) {
            throw new IllegalArgumentException("Invalid amount. Amount must be greater than zero.");
        }
        this.amount = amount;
    }

    public static int getTotalOrders() {
        return totalOrders;
    }

    public static void displayTotalOrders() {
        System.out.println("Total orders processed: " + totalOrders);
    }

    public abstract double calculateDeliveryCharge();
}
