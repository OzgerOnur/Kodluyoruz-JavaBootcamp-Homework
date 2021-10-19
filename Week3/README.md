# Homework 3

3 Category

2 Subcategory

Product tree should be created with a minimum of 3 products in each sub-category.

| Main Category     | Subcategory  | Product                            |
|-------------------|--------------|------------------------------------|
| Fruit & Vegetable | Fruit        | Apple,Pear,Grape                   |
| Fruit & Vegetable | Vegetable    | Tomato,Pepper,Eggplant             |
| Snack             | Chips        | Lays,Doritos,Ruffles               |
| Snack             | Chocolate    | Tadelle,Albeni,Metro,Hobby         |
| Breakfast         | Milk         | Full-fat,Low-fat,Lacto-free        |
| Breakfast         | Delicatessen | Cheddar,Cheese,Salami,Susage,Olive |

Product details include the following information:
- Name
- Description
- Price

The First Page opens with the main menu, Search selection.

### Main Menu

Main categories are listed.  
After category selection, sub-categories are listed and selection is made.  
The products belonging to the sub-category will be listed. The product number to be added to the cart is entered.  
After the product selection, the product detail is printed.  
The quantity information to be added to the cart is entered. If the product is in the cart, the quantity information is updated.  
After the adding process is finished, you are given the opportunity to view **the Checkout Page** or return to **the First Page**.

### Search

Minimum 3 characters must be entered. The products containing the searched text are retrieved among the products in all categories and subcategories. The product number to be added to the cart is entered.
After the product selection the product detail is printed.  
The quantity information to be added to the cart is entered.  
After the adding process is finished, you are given the opportunity to view **the Checkout Page** or return **the First Page**.

### Checkout

Discount rules will be applied with **Strategy Pattern**  
Discount rules are be explaned `Discount` section.  
The products in the cart listed:  
name, quantity, description, unit price, unit discounted price(based on discount rule) and item price.
Cart total, Total earned discount and Payable total should be included. `Delivery Fee` for each basket is added to the total amount to be paid. If the total amount to be paid is over `Delivery Fee Limit` the return fee is 0 TL.  
You are given the opportunity to return to **the First Page** or **Pay**

`Delivery Fee:` Should defined in the `Application.yaml`  
`Delivery Fee Limit:` Should defined in the `Application.yaml`

### Payment

There is two different payment method. `Cash` and `CreditCart`.  
You are given the opportunity to the select a payment method.  
Based on the user option payment method should be applied. **Factory Pattern** should be used for this implementation.  
User should be informed payment method commission after the payment completed.

1. Cash:
    - The commission should be 0.
2. CreditCart
    - The commission should be defined `Application.yaml`

### Discount

There is two different discount type should be created. `Buy2Take3Discount` and `PercentageDiscount`. There is a priority between discounts.

1. PercentageDiscount:
    - Cart Total greater than 1000 TL discount will be applied. Discount Percantage should be learned from `Application.yaml`and will calculate the discount for products which in the cart.
2. Buy2Take3Discount:
    - Cart have more than 5 different product discount will be applied. Discount will be applied for product which quantity greater or equal 3.

**Only one discount can be applied. If the cart does not meet the requirement, the discount may not be applied.**

## Application.yaml

- Active Profile: `prod`
    - Delivery Fee: 5
    - Delivery Fee Limit: 100
    - Discount Percentage: 20
    - CreditCart Commission: %8
- Active Profile: `dev`
    - Delivery Fee: 2
    - Delivery Fee Limit: 50
    - Discount Percentage: 15
    - CreditCart Commission: %2

## Remarks and Notation

* Spring boot should be used.
* SOLID principles must be followed.
* UML Diagram which ide generated should be added to the repo as image. UML should includes:
    * Fields
    * Constructors
    * Methods
    * Show Dependencies enabled