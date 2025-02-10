package org.capgemini.problem_2;

import java.util.*;

// Base class for products
abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            this.price -= this.price * (percentage / 100);
        }
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

// Specific Product Categories
class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }
}

class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }
}

class Gadget extends Product {
    public Gadget(String name, double price) {
        super(name, price);
    }
}

// Generic Product Catalog
class ProductCatalog<T extends Product> {
    private final List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public void applyDiscountToAll(double percentage) {
        for (T product : products) {
            product.applyDiscount(percentage);
        }
    }

    public void displayProducts() {
        for (T product : products) {
            System.out.println(product);
        }
    }
}

// Main Class for Testing
public class MarketPlace {
    public static void main(String[] args) {
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        bookCatalog.addProduct(new Book("Java Programming", 50.0));
        bookCatalog.addProduct(new Book("Data Structures", 40.0));

        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        clothingCatalog.addProduct(new Clothing("T-Shirt", 20.0));
        clothingCatalog.addProduct(new Clothing("Jeans", 60.0));

        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();
        gadgetCatalog.addProduct(new Gadget("Smartphone", 500.0));
        gadgetCatalog.addProduct(new Gadget("Headphones", 100.0));

        System.out.println("Before Discount:");
        bookCatalog.displayProducts();
        clothingCatalog.displayProducts();
        gadgetCatalog.displayProducts();

        bookCatalog.applyDiscountToAll(10);
        clothingCatalog.applyDiscountToAll(15);
        gadgetCatalog.applyDiscountToAll(5);

        System.out.println("\nAfter Discount:");
        bookCatalog.displayProducts();
        clothingCatalog.displayProducts();
        gadgetCatalog.displayProducts();
    }
}
