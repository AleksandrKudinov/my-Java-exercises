
/*    This program output the multiplication of two matrix, which user inputs.
 */

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {

        Scanner  rowsnumber = new Scanner(System.in);
        Scanner  coloumsnumber = new Scanner(System.in);
        Scanner ij = new Scanner(System.in);

        //"Matrix" class with "elements" method for entering the elements of the matrices
        class  Matrix {
        int n;
        int m;
        int[][] matrix = new int[n][m];

          int[][] elements(){
             for(int i=0;i<matrix.length; i++){
                for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] = ij.nextInt();
                }
             }
          return matrix;
          }
        }

        //Entering dimensions of matrices with checking for compliance
        Matrix MatrixA = new Matrix();
        Matrix MatrixB = new Matrix();
        do {
            System.out.println("Enter the number of rows of the matrix A (greater than 0): ");
            MatrixA.n = rowsnumber.nextInt();
            System.out.println("Enter the number of columns of the matrix A (greater than 0): ");
            MatrixA.m = coloumsnumber.nextInt();
            System.out.println("Enter the number of columns of the matrix B (greater than 0): ");
            MatrixB.m = coloumsnumber.nextInt();
            if (MatrixA.n==0 || MatrixA.m==0 || MatrixB.m==0 ){
                System.out.println("!The dimension of the matrix must be nonzero!");
            }
        }while(MatrixA.n==0 || MatrixA.m==0 || MatrixB.m==0 );
        //Entering the elements of the first matrix
        System.out.println("Enter the elements of the matrix A");
        MatrixA.matrix = new int [MatrixA.n][MatrixA.m];
        MatrixA.elements();

        //Entering the elements of the second matrix
        System.out.println("Enter the elements of the matrix B");
        MatrixB.matrix = new int [MatrixA.m][MatrixB.m];
        MatrixB.elements();

        //The sum of multiplication of the corresponding elements with the output of the result
        System.out.println();
        System.out.println("Matrix С = А*В: ");
        System.out.println();
        int[][] matrixC = new int[MatrixA.n][MatrixB.m];
        for(int i=0;i<matrixC.length; i++){
            for(int j=0;j<matrixC[i].length;j++){
                for(int summ =0; summ < MatrixA.m;summ++){
                    int p = matrixC[i][j];
                    matrixC[i][j] = MatrixA.matrix[i][summ] * MatrixB.matrix[summ][j];
                    matrixC[i][j] = matrixC[i][j] + p;
                }
                System.out.print(matrixC[i][j]+" ");
            }
            System.out.println();
        }
    }
}


// Created by Aleksandr Kudinov on 21.9.19


