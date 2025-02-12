package org.capgemini.shopping_cart;

import java.util.*;

public class ShoppingCart {
    private final Map<String, Double> productPrices = new HashMap<>();
    private final Map<String, Integer> cart = new LinkedHashMap<>();
    private final Map<String, Double> sortedCart = new TreeMap<>(Comparator.comparing(productPrices::get));

    // Method to add a product with its price
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Method to add an item to the cart
    public void addItemToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
        sortedCart.put(product, productPrices.get(product));
    }

    // Method to remove an item from the cart
    public void removeItemFromCart(String product) {
        if (cart.containsKey(product)) {
            cart.remove(product);
            sortedCart.remove(product);
            System.out.println(product + " removed from cart.");
        } else {
            System.out.println("Item not found in cart: " + product);
        }
    }

    // Display cart in insertion order
    public void displayCartInsertionOrder() {
        System.out.println("\nCart (Insertion Order - LinkedHashMap):");
        cart.forEach((product, quantity) ->
                System.out.println(product + " (x" + quantity + ") - $" + (productPrices.get(product) * quantity)));
    }

    // Display cart sorted by price
    public void displayCartSortedByPrice() {
        System.out.println("\nCart (Sorted by Price - TreeMap):");
        sortedCart.forEach((product, price) ->
                System.out.println(product + " - $" + price));
    }

    // Calculate total price
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct("Laptop", 800);
        cart.addProduct("Phone", 500);
        cart.addProduct("Headphones", 200);
        cart.addProduct("Keyboard", 100);

        // Adding items to the cart
        cart.addItemToCart("Laptop", 1);
        cart.addItemToCart("Phone", 2);
        cart.addItemToCart("Headphones", 1);
        cart.addItemToCart("Keyboard", 3);

        // Displaying cart
        cart.displayCartInsertionOrder();
        cart.displayCartSortedByPrice();

        // Total price
        System.out.println("\nTotal Price: $" + cart.getTotalPrice());

        // Removing an item and re-displaying cart
        cart.removeItemFromCart("Phone");
        cart.displayCartInsertionOrder();
    }
}
