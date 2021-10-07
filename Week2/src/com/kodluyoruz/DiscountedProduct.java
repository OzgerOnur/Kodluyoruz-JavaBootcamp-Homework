package com.kodluyoruz;

/**
 * Subclass representing a discounted product to be
 * purchased. It extends the Product class with two instance variables
 */
public class DiscountedProduct extends Product {
    // Original product
    private final Product original;

    // Discount in percent (%)
    private final double discount;

    /**
     * Construct a discounted product
     * @param original
     * @param discount
     */
    public DiscountedProduct(Product original, double discount) {
        // if the price can not be reduced you should print a message and
        // terminate the program. Use IllegalArgumentException to terminate.
        // code here
        super(original);
        this.original = original;
        this.discount = discount;


    }

    /**
     * Return the price of this discounted product
     * @param cart shopping cart
     * @return discounted price
     */
    @Override
    public double getPrice(Cart cart) {
        // code here
        return super.getPrice(null) * (100-discount)/100 ;
    }

    /**
     * Return the string representation of the product
     * Example: CD [discounted 20 %]
     */
    @Override
    public String toString() {
        return super.getName() + "[discounted by "+ discount +"%] ";
    }
}
