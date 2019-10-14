/*
    This program calculate the determinant of the matrix entered by the user with dimension n
    and output step-by-step conversions.
*/

import java.util.Scanner;

public class Determinant {
    public static Scanner dimension = new Scanner(System.in);
    public static Scanner element = new Scanner(System.in);
    static int determinantSign =1;
    public static void main(String[] args) {
        System.out.println("enter the dimension of the matrix A:");
        int n=dimension.nextInt();
        double[][] matrix = new double[n][n];
        double[][] matrixInitial = new double[n][n];
        double determinant = 1;

        System.out.println("enter the elements of the matrix A:");
        for (int i = 0; i < n; i++) {  //assigning values of matrix elements to variables
            for (int j = 0; j < n; j++) {
                matrix[i][j] = element.nextDouble();
                matrixInitial[i][j] = matrix[i][j];
            }
        }

        determinant(0,n,matrix,matrixInitial);
        System.out.print("Determinant = "+determinantSign+" * ( ");
        for (int i = 0; i < n; i++) { //multiply matrix elements on main diagonal and output with rounding
            determinant = matrix[i][i] * determinant;
            System.out.printf("%.2f * ",matrix[i][i]);
        }
        System.out.printf("\b\b) = %.3f", determinantSign*determinant);
    }

    public static void determinant(int m,int n, double[][] matrix,double[][] matrixInitial) {     //reduction of matrix elements to triangular form
        if (m == n-1)
            return;
        one:
        {
            if (matrix[m][m] == 0) {        // check the element on main diagonal for equality to 0
                int k = m;
                while (matrix[k][m] == 0) {         //find the element on column, which not equality to 0
                    if (k == n-1) {
                        break one;
                    }
                    k++;
                }
                for (int j = m; j < n; j++) {       // change elements of strings and sign of determinant
                    matrix[m][j] = matrix[k][j];
                    matrix[k][j] = matrixInitial[m][j];
                }
                determinantSign = -determinantSign; // change sign of determinant

                //output changes in the matrix
                System.out.printf("replace elements from the %d string with the elements in the %d string \n",k+1,m+1);
                System.out.println("det(A) = -det(A)");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.printf("%10.2f", matrix[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            two:
            {
                int k = m + 1;
                while (matrix[k][m] == 0) {     //find the element on column, which not equality to 0
                    if (k == n - 1) {
                        break two;
                    }
                    k++;
                }
                double coefficient;
                for (int i = m + 1; i < n; i++) {  //find the coefficient and recalculation of the string elements
                    if (matrix[i][m] != 0) {
                        coefficient = -matrix[i][m] / matrix[m][m];
                        System.out.printf("multiply the %d string elements on  -(%.2f / %.2f) = %.2f and sum with elements on the %d string \n", m + 1, matrix[i][m], matrix[m][m], coefficient, i + 1);
                        for (int j = m; j < n; j++) {
                            matrix[i][j] = matrix[i][j] + (matrix[m][j] * coefficient);
                            matrixInitial[i][j] = matrix[i][j];
                        }
                    } else {
                        for (int j = m; j < n; j++) {
                            matrixInitial[i][j] = matrix[i][j];
                        }
                    }
                }

                //output changes in the matrix
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.printf("%10.2f", matrix[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            determinant(m + 1,n,matrix,matrixInitial);
        }
    }
}


// Created by Alexandr Kudinov on 14.10.19