package Q2;

import java.util.Scanner;

import static Q2.OccursIn.occursIn;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the pattern string: " );
        String pattern = sc.nextLine();

        while (true){
            System.out.print("Enter a string: ");
            String str = sc.nextLine();
            if (str.equals("exit")) {
                System.out.println("bye");
                break;
            }

            if (occursIn(pattern, str)){
                System.out.println(pattern + " occurs in " +  "\"" + str + "\"");
            }else
            {
                System.out.println(pattern + " does NOT occur in " + "\"" + str + "\"");
            }
        }













    }

}
