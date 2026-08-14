package food.utility;

import food.model.Discountable;
import food.model.FoodOrder;

public class OrderUtility {
    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String name) {
        if (name == null) {
            return false;
        }
        String trimmed = name.trim();
        if (trimmed.length() < 3) {
            return false;
        }
        return trimmed.matches("[A-Za-z ]+");
    }

    public static String generateOrderSummary(FoodOrder order) {
        double amount = order.getAmount();
        double deliveryCharge = order.calculateDeliveryCharge();
        double discount = 0;
        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }
        double payable = amount - discount + deliveryCharge;

        StringBuilder builder = new StringBuilder();
        builder.append("Order Id: ").append(order.getOrderId())
                .append(" | Customer: ").append(order.getCustomerName())
                .append(" | Type: ").append(order.getClass().getSimpleName())
                .append("\n  Amount: Rs. ").append(String.format("%.2f", amount))
                .append(" | Discount: Rs. ").append(String.format("%.2f", discount))
                .append(" | Delivery Charge: Rs. ").append(String.format("%.2f", deliveryCharge))
                .append(" | Final Payable: Rs. ").append(String.format("%.2f", payable));
        return builder.toString();
    }
}
