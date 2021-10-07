# Homework 2

In this assignment, you will write an object-oriented application for a shopping cart software. The software allows shopping customers to accumulate a list of products for purchase. Upon checkout, the software should calculate the total price for a order and show the products to the customer.

## The Task

In this assignment, you are given the specifications of a shopping cart application which you need to implement. The application consists of the following classes:

* A Product class representing a product to be purchased
* A DiscountedProduct subclass representing a product with x% discount
applied to it
* A Buy2Take3Product subclass representing a product for which one can
buy 2 pieces and get a third for free
* A Cart class representing the products purchased by a given customer
* A Main class representing the interface between the customer and the
shopping cart application

The specification takes the form of a set of commented java files.

# The interface, example session

The class **Main** has a main method which, when executed, should lead to an interactive user session of the following kind:


    Welcome to kodluyoruz shop
    What’s your name?
    Efe
    Hi Efe. Please choose one of the following options:
    Enter 1 to buy a product
    Enter 0 to checkout and proceed with the payment
    1
    Product name: CD of Teoman
    Seller: Berk
    Price: 30
    How many: 4
    Discount (enter 0 if no discount applies): 0
    Does Buy2Take3 apply? Y/N Y
    Enter 1 to buy a product
    Enter 0 to checkout and proceed with the payment
    1
    Product name: TV
    Seller: Merve
    Price: 5000
    How many: 1
    Discount (enter 0 if no discount applies): 20
    Does Buy2Take3 apply? Y/N N
    Enter 1 to buy a product
    Enter 0 to checkout and proceed with the payment
    0
    CD of Teoman 22.50 TL. Sold by Berk
    CD of Teoman 22.50 TL. Sold by Berk
    CD of Teoman 22.50 TL. Sold by Berk
    CD of Teoman 22.50 TL. Sold by Berk
    TV [discounted by 20.00%] 4000.00 TL. Sold by Merve
    In total you have to pay 4090.0 TL

# Remarks and Notation
* If a user buys the same product twice, these instances should be considered as buying different products.
* The program should terminate with IllegalArgumentException if the user chooses both the discount and the offer Buy2Take3, since Buy2Take3 products can not be discounted.
* Method getPrice requires cart as parameter, since in the subclasses the price of a product may depend on other products in the cart. Think what happens for objects of type Buy2Take3