package com.kodluyoruz;

import java.util.HashMap;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {

        String[] questions = {"Product name: ","Seller: ","Price: ","How many: ",
                "Discount (enter 0 if no discount applies): ","Does Buy2Take3 apply? Y/N "};
        String[] keys = {"name","seller","price","number","discount","buy2Take3"};
        HashMap<String,String> inputs = new HashMap<>();

        for (int i = 0; i< questions.length;i++){
            System.out.println(questions[i]);
            Scanner s = new Scanner(System.in);
            inputs.put(keys[i],s.nextLine());
        }
        System.out.println(inputs.get("name"));
        System.out.println(inputs.get("---"));
        System.out.println(inputs.get(keys[0]));
    }
}
