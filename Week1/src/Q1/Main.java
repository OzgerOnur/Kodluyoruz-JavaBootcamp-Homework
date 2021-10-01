package Q1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("N = ");
        Scanner input= new Scanner(System.in);
        int N = input.nextInt();

        for(int i = 1; i <= N;i++) { // satır başları

            if(i==1 || i==N){ // alt ve üst satılar
                for (int j = 0;j<N;j++)
                    System.out.print("*");
                System.out.println();
                continue;
            }
            for (int j = 1; j<=N ; j++){// sütunlar

                if (j == 1 || j == N) {
                    System.out.print("*");
                    continue;
                }
                if ((i % 2) == 0) {

                    if ((j % 2) == 0)
                        System.out.print("+");
                    else
                        System.out.print(" ");
                }
                else
                {
                    if ((j % 2) == 0)
                        System.out.print(" ");
                    else
                        System.out.print("+");
                }


            }








            System.out.println();
        }














    }

}


