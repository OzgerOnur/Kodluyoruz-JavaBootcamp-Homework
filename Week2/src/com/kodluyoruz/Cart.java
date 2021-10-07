package com.kodluyoruz;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the shopping cart
 */

public class Cart {
    // list of products
    private final List<Product> products;

    public Cart(){
        products = new ArrayList<>();
    }

    /**
     * Return the list of products
     * @return
     */
    public List<Product> getProducts(){
        // code here
        return products;
    }

    /**
     * Add a product to the list
     * @param product
     */
    public void addProduct(Product product) {
        // code here
        this.products.add(product);




    }

    /**
     * Add an list of products to the list
     *  @param products
     */
    public void addProducts(List<Product> products) {
         // code here
        for (Product p: products) {
            addProduct(p);

        }

    }

    /**
     * Adds a product several times
     * @param product
     * @param howManyTimes number of times to add product
     */
    public void addProduct(Product product, int howManyTimes) {
        // code here
    }

    /**
     * Calculate the total price
     * @return
     */
    public double totalPrice(){
        // code here
        int count = 0;
        for (Product p: products) {
            count += p.getPrice(this);

        }
        return count;
    }

    /**
     * String representation of products in a shopping cart
     * Example:
     * CD of Teoman 22.50 TL. Sold by Berk
     * TV [discounted by 20.00%] 4000.00 TL. Sold by Merve
     */
    public String toString() {
        String result = "";
        // code here
        for (Product p: products) {
            result = result + p.toString() + " " +
                    p.getPrice(this) + " TL. Sold by " + p.getSeller() + "\n";

        }
        result = result + "In total you have to pay " + this.totalPrice() + "\n";
        return result;
    }

}

