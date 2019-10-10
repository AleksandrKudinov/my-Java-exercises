
/*
    This program output the elements of the Fibonacci sequence,
    until the number, which user inputs.
*/

import java.util.Scanner;

public class Fibonacci {
        public static void main (String[] args) {
            Scanner n = new Scanner(System.in);
            System.out.println("Enter an integer, more than 1:  ");
            int f = n.nextInt();
            int a = 0; //set the first element of the sequence
            int b = 1; //set the second element of the sequence
            System.out.println("Elements of the Fibonacci sequence, until the "+f +":");
            System.out.println(a);
            System.out.println(b);
            int c; //set the storage variable for the sum
            while (a + b  <= f){   //determine the elements of the sequence
                System.out.println(a+b+" ");
                c = a + b;
                a = b;
                b = c;
                }
            }
        }
    // Created by Alexandr Kudinov on 15.9.19
