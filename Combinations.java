
/*
    This program output all  k-combinations of natural numbers from 0 to n-1
    (without using recursion)
*/

import java.util.Scanner;
public class Combinations {
    public static void main(String[] args) {
        Scanner parameter = new Scanner(System.in);
        int n,k;
        do {    //input parameters of the binomial coefficient
            System.out.println("enter n:");
            n = parameter.nextInt();
            System.out.println("enter k:");
            k = parameter.nextInt();
            if(n==0 || k==0){
                System.out.println("n & k must bo more than 0");
            }
        }while(n==0 || k==0);

        int[] combination = new int[k]; //set value of combination as array
        int numberInOrder=1; // number of combination in order (! last combination number is a value of the binomial coefficient  from k of n)
        for (int i = 0; i < Math.pow(n, k); i++) { // representation of numbers from 0 to n^k in the n-ary number system with length k
                int numberInDecimalNotation = i;
                one:
                {
                    for (int j = 0; j <= k - 1; j++) {
                        combination[j] = (numberInDecimalNotation / (int) (Math.pow(n, k - 1 - j)));
                        numberInDecimalNotation = numberInDecimalNotation - combination[j] * (int) (Math.pow(n, k - 1 - j));
                    }
                    int w = 0;
                    while (w != k - 1) { //choose only those combinations in which any right element is greater than the left
                        if (combination[w] < combination[w + 1]) {
                            w = w + 1;
                        } else {
                            break one;
                        }
                    }

                    System.out.print(numberInOrder+": ");
                    numberInOrder++;
                    for (int q = 0; q <= k - 1; q++) {
                        System.out.print(combination[q]);
                    }
                    System.out.println();
                }
        }
    }
}

// Created by Alexandr Kudinov on 02.10.19
