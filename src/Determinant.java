/*
    This program calculate the determinant of the matrix entered by the user with dimension n.
*/

import java.util.Scanner;

public class Determinant {
    public static Scanner dimention = new Scanner(System.in);
    public static Scanner elament = new Scanner(System.in);
    public static int n = dimention.nextInt();
    public static double[][] matrix = new double[n][n];
    public static double[][] matrixInitial = new double[n][n];
    public static int determinantSign =1;

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {  //input matrix elements
            for (int j = 0; j < n; j++) {
                matrix[i][j] = elament.nextDouble();
                matrixInitial[i][j] = matrix[i][j];
            }
        }
        determinant(1);

        /*
        //Output matrix elements, after all transformations
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
        */

        double determinant = 1;
        for (int i = 0; i < n; i++) { //calculate matrix elements on main diagonal, with rounding and output
            determinant = matrix[i][i] * determinant;
        }
        double determinantRound = Math.round(determinant * 1000.0) / 1000.0;
        System.out.println("Determinant = " + determinantSign*determinantRound);

    }

    public static void determinant(int m) {     //reduction of matrix elements to triangular form
        if (m == n)
            return;
        one:
        {

            if (matrix[m - 1][m - 1] == 0) {        // check the element on main diagonal for equality to 0
                int k = m;
                while (matrix[k - 1][m - 1] == 0) {         //find the element on column, which not equality to 0
                    if (k == n) {
                        break one;
                    }
                    k++;
                }
                for (int j = m - 1; j < n; j++) {       // change elements of strings and sign of determinant
                    matrix[m - 1][j] = matrix[k-1][j];
                    matrix[k-1][j] = matrixInitial[m - 1][j];
                    determinantSign = -determinantSign;
                }

            }
            for (int i = m; i < n; i++) {       //find the coefficient and recalculation of the string elements
                if (matrix[i][m - 1] != 0) {
                    double coefficient = -matrix[i][m - 1] / matrix[m - 1][m - 1];
                    for (int j = m - 1; j < n; j++) {
                        matrix[i][j] = matrix[i][j] + (matrix[m - 1][j] * coefficient);
                        matrixInitial[i][j] = matrix[i][j];
                    }
                }
            }
            determinant(m + 1);
        }
    }
}

// Created by Alexandr Kudinov on 09.10.19