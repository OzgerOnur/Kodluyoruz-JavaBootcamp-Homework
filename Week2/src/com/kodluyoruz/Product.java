package com.kodluyoruz;

/**
 * Class representing a product to be purchased
 */

public class Product {

    // Name of the seller
    private final String seller;
    // Name of the product
    private final String name;
    // Price of the product
    private final double price;

    /**
     * Construct a new Product given the following parameters
     * @param seller
     * @param name
     * @param price
     */
    public Product(String seller, String name, double price) {
        //initialize fields
        this.seller = seller;
        this.name = name;
        this.price = price;
    }

    /**
     * Construct a new Product from a given product
     * @param original
     */
    public Product(Product original) {
        // Use the constructor implemented above
        this.seller = original.getSeller();
        this.name = original.getName();
        this.price = original.getPrice(null);

    }

    /**
     * Return the seller of this product
     * @return seller
     */
    public final String getSeller() {
        //code here
        return seller;
    }

    /**
     * Return the name of this product
     * @return name
     */
    public final String getName() {
        // code here
        return name;
    }

    /**
     * Return the price of this product
     * @param cart
     * @return price
     */
    public double getPrice(Cart cart) { // why is this which contain cart here
        // code here
        return price;
    }


    /**
     * Returns true if the price of this product
     * can be reduced
     * @return
     */
    public boolean canBeReduced() {
        //Nothing to do here
        return true;
    }

    /**
     * Return the name of the product
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
