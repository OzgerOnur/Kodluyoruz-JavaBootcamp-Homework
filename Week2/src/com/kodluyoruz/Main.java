package com.kodluyoruz;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     * This is the main class for the application, interacting
     * with the customer, adding to the cart different products to
     * be purchased and finally calculating the total amount to be paid
     */

    /**
     * Allows a cashier to enter the details for a product
     * to be purchased by a customer
     * @param cart the shopping cart of a given customer
     */
    public static void askCustomer(Cart cart){
        // Code to read from console the product name, seller,
        // price, number of products, discount and
        // if Buy2Take3 applies.
        // Then create a product of the correct type
        // and add it to the shopping cart
        String[] questions = {"Product name: ","Seller: ","Price: ","How many: ",
                            "Discount (enter 0 if no discount applies): ","Does Buy2Take3 apply? Y/N "};
        String[] keys = {"name","seller","price","amount","discount","buy2Take3"};
        HashMap<String,String> inputs = new HashMap<>();

        for (int i = 0; i< questions.length;i++){
            System.out.println(questions[i]);
            Scanner s = new Scanner(System.in);
            inputs.put(keys[i],s.nextLine());
        }
        List<Product> productList  = new ArrayList<>();

        for (int i = 0;i<Integer.parseInt(inputs.get("amount"));i++) {
            if (inputs.get("buy2Take3").equals("Y")) {
                if (Integer.parseInt(inputs.get("discount")) > 0){
                    System.out.println("Gecersiz giris!");
                    return;
                }

                productList.add(new Buy2Take3Product(new Product(
                        inputs.get("seller"),
                        inputs.get("name"),
                        Double.parseDouble(inputs.get("price"))))
                );


            }else if (inputs.get("buy2Take3").equals("N")) {

                productList.add(new DiscountedProduct(new Product(
                        inputs.get("seller"),
                        inputs.get("name"),
                        Double.parseDouble(inputs.get("price"))),
                        Double.parseDouble(inputs.get("discount")))

                );

            }
        }
        cart.addProducts(productList);




    }

    // Main method to interact with a customer
    public static void main(String[] args) {
        System.out.println("Welcome to kodluyoruz shop");
        System.out.println("What’s your name?");

        Scanner scanner = new Scanner(System.in);
        String customer = scanner.nextLine();

        System.out.println("Hi " + customer + ". Please choose one of the following options:");
        System.out.println("");

        Cart cart = new Cart();

        //Implement the user interface here +
        // Ask the user to choose 0 (buy product) or +
        // 1 (checkout), depending on what they want to do. +
        // Use the method askCustomer +
        while(true){
            System.out.println("Enter 1 to buy a product"+ "\n" +
                    "Enter 0 to checkout and proceed with the payment");
            int i = scanner.nextInt();
            if(i == 1){
                askCustomer(cart);
            }else if(i == 0){
                //payment'i hesapla
                System.out.println(cart.toString());
                break;
            }

        }

    }
}

