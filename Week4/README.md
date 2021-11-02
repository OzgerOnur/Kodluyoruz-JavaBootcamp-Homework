# Homework 4

You should implement an API which contains CategoryController, ProductController, UserController, BasketController, CheckoutController and OrderController. Database should be Postgresql. JPA code first approach should be followed.

## Category Controller
You should use CRUD operations.  
Decide on your own how the methods should look like.  
Entity Category: can be a subcategory or maincategory.  
/categories/{id}/parent -> This route should return parent of a category.
/categories/{id}/products -> This route should return products of a category.
/categories/{id}/subcategories -> This route should return subcategories of a category.

## Product Controller
You should use CRUD operations.  
Decide on your own how the methods should look like.  
Also should be reachable related category on the product.

## User Controller
You should use CRUD operations.  
Decide on your own how the methods should look like.  

## Basket Controller
Basket entity should be related with user.
Only 1 basket should active for a user without checkout completed.

## Checkout Controller
Checkout should be related with user.  
User can have active basket checkout at checkout. 
User can complete basket and should create an order based on the basket.

## Order Controller
Order should be related with user.  
User can see all the orders that have.  
User can get single order with orderId.

## Entity Models
**These entities are hint, relations are not included between entites**

* Category
    * name

* Product
    * name
    * description
    * price

* Basket: includes product with quantity
* Order: includes product with quantity and unit price, total paid price

## Example Scenario

![Scenario](/example.png "Scenario")

## Notes

* You should use Map struct.