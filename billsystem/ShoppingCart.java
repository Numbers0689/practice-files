import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> cartItems;

    public ShoppingCart() {
        cartItems = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        if (cartItems.containsKey(product)) {
            cartItems.put(product, cartItems.get(product) + quantity);
        } else {
            cartItems.put(product, quantity);
        }
        product.setQuantity(product.getQuantity() - quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public String getCartDetails() {
        StringBuilder details = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            details.append(entry.getKey().getName())
                   .append(" x ")
                   .append(entry.getValue())
                   .append(" = ₹")
                   .append(entry.getKey().getPrice() * entry.getValue())
                   .append("\n");
        }
        details.append("Total: ₹").append(calculateTotal());
        return details.toString();
    }
}
