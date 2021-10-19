package com.kodluyoruz.HW3;

import com.kodluyoruz.HW3.cartsAndBills.Bill;
import com.kodluyoruz.HW3.cartsAndBills.Cart;
import com.kodluyoruz.HW3.cartsAndBills.CartItem;
import com.kodluyoruz.HW3.paymentMethods.PaymentFactory;
import com.kodluyoruz.HW3.paymentMethods.PaymentMethods;
import com.kodluyoruz.HW3.paymentMethods.enums.PaymentType;
import com.kodluyoruz.HW3.productAndCategory.Categorys;
import com.kodluyoruz.HW3.productAndCategory.Product;
import com.kodluyoruz.HW3.properties.DiscountProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class Main2Hw3 implements CommandLineRunner {
    private final List<Product> productsList = dbStarter();
    private final Scanner scanner;
    private final Cart cart;
    private final PaymentFactory paymentFactory;


    @Override
    public void run(String... args) throws Exception {


        while (true){
            System.out.println("For main menu - 1\nFor Search selection - 2");
            int i = scanner.nextInt();
            scanner.nextLine();
            if (i == 1){
                mainMenu();

            }else if(i==2){
                searchMenu();

            }

        }






    }

    private void mainMenu() {
        List<Product> plist = productsList;
        String selectMain,selectSub,selectProduct;

        try {
            System.out.println("Please select main category");
            plist.stream().map(p->p.getCategorys().getMainCategoryName()).distinct().forEach(System.out::println);
            selectMain = scanner.nextLine();
            plist = plist.stream().
                    filter(p -> p.getCategorys().getMainCategoryName().equals(selectMain)).
                    collect(Collectors.toList());

            System.out.println("Please select sub category");
            plist.stream().map(p->p.getCategorys().getSubCategoryName()).distinct().
                    forEach(System.out::println);
            selectSub = scanner.nextLine();
            plist = plist.stream().
                    filter(p -> p.getCategorys().getSubCategoryName().equals(selectSub)).
                    collect(Collectors.toList());

            System.out.println("Please select product");
            plist.stream().map(Product::getName).distinct().
                    forEach(System.out::println);
            selectProduct = scanner.nextLine();
            plist = plist.stream().
                    filter(p -> p.getName().equals(selectProduct)).
                    collect(Collectors.toList());

            System.out.println("How many do you want to buy " + plist.get(0).getName());
            int productQuantity = scanner.nextInt();
            scanner.nextLine();
            cart.addCart(CartItem.builder().
                    product(plist.get(0)).
                    quantity(productQuantity).
                    build());
        }
        catch (Exception e){
            return;
        }
        System.out.println("Please for turn back - 1 \nfor Checkout - 2");
        int selectMenu = scanner.nextInt();
        scanner.nextLine();
        if (selectMenu == 2)
            checkOut();
        else
            return;


    }

    private void searchMenu() {
        String searchedWord;
        do {
            System.out.println("What is your searching word, it should be more than 3 character");
            searchedWord = scanner.nextLine();
        }while (searchedWord.length() < 3);

        System.out.println("Please select product");
        String finalSearchedWord = searchedWord;
        AtomicInteger index = new AtomicInteger();
        List<Product> searchList = productsList.stream().
                filter(s->s.getName().contains(finalSearchedWord)).
                distinct().
                peek(p -> System.out.println(index.getAndIncrement() +" - " + p)).
                collect(Collectors.toList());
        if(searchList.isEmpty()) {
            System.out.println("There is not any product you searched");
            return;
        }
        int i = scanner.nextInt();
        scanner.nextLine();
        searchList = searchList.subList(i, i+1);
        System.out.println(searchList.get(0).getDescription());
        System.out.println("How many do you want to buy " + searchList.get(0).getName());
        i = scanner.nextInt();
        scanner.nextLine();
        cart.addCart(CartItem.builder().
                product(searchList.get(0)).
                quantity(i).
                build());

        System.out.println("Please for turn back - 1 \nfor Checkout - 2");
        int selectMenu = scanner.nextInt();
        scanner.nextLine();
        if (selectMenu == 2)
            checkOut();
        else
            return;

    }

    private void checkOut(){
        Bill bill = cart.checkOut();
        System.out.println(bill);
        System.out.println("Please for turn back - 1 \nfor Pay - 2");
        int selectMenu = scanner.nextInt();
        scanner.nextLine();
        if (selectMenu == 2)
            payment(bill);
        else
            return;

    }

    private void payment(Bill bill){
        System.out.println("Payment methodu seçin" + Arrays.toString(PaymentType.values()));
        PaymentType paymenttype = PaymentType.valueOf(scanner.nextLine());
        PaymentMethods paymentmethod = paymentFactory.getPaymentMethod(paymenttype);
        paymentmethod.pay(bill);


    }

    public List<Product> dbStarter(){

        String[] mainCategoryS = {"Fruit & Vegetable","Snack","Breakfast"};
        String[] subCategoryS =  {"Fruit","Vegetable","Chips","Chocolate","Milk","Delicatessen"};

        List<Product> productsList = Arrays.asList(



                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[0]).subCategoryName(subCategoryS[0]).build()).name("Apple").description("AppleAA").price(1).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[0]).subCategoryName(subCategoryS[0]).build()).name("Pear").description("PearAA").price(2).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[0]).subCategoryName(subCategoryS[0]).build()).name("Grape").description("GrapeAA").price(3).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[0]).subCategoryName(subCategoryS[1]).build()).name("Tomato").description("TomatoAA").price(4).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[0]).subCategoryName(subCategoryS[1]).build()).name("Pepper").description("PepperAA").price(5).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[0]).subCategoryName(subCategoryS[1]).build()).name("Eggplant").description("EggplantAA").price(6).build(),

                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[1]).subCategoryName(subCategoryS[2]).build()).name("Lays").description("LaysAA").price(1).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[1]).subCategoryName(subCategoryS[2]).build()).name("Doritos").description("DoritosAA").price(2).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[1]).subCategoryName(subCategoryS[2]).build()).name("Ruffles").description("RufflesAA").price(3).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[1]).subCategoryName(subCategoryS[3]).build()).name("Tadelle").description("TadelleAA").price(4).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[1]).subCategoryName(subCategoryS[3]).build()).name("Albeni").description("AlbeniAA").price(5).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[1]).subCategoryName(subCategoryS[3]).build()).name("Metro").description("MetroAA").price(6).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[1]).subCategoryName(subCategoryS[3]).build()).name("Hobby").description("HobbyAA").price(7).build(),

                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[2]).subCategoryName(subCategoryS[4]).build()).name("Full-fat").description("Full-fatAA").price(1).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[2]).subCategoryName(subCategoryS[4]).build()).name("Low-fat").description("Low-fatAA").price(2).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[2]).subCategoryName(subCategoryS[4]).build()).name("Lacto-free").description("Lacto-freeAA").price(3).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[2]).subCategoryName(subCategoryS[5]).build()).name("Cheddar").description("CheddarAA").price(4).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[2]).subCategoryName(subCategoryS[5]).build()).name("Cheese").description("CheeseAA").price(5).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[2]).subCategoryName(subCategoryS[5]).build()).name("Salami").description("SalamiAA").price(6).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[2]).subCategoryName(subCategoryS[5]).build()).name("Susage").description("SusageAA").price(7).build(),
                Product.builder().categorys(Categorys.builder().mainCategoryName(mainCategoryS[2]).subCategoryName(subCategoryS[5]).build()).name("Olive").description("OliveAA").price(8).build()




        );


        System.out.println("\n----\n");
        System.out.println(productsList);
        System.out.println("\n----\n");

    return productsList;


    }
}
