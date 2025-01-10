/*
 * 
 * Write a program to print the following pattern
 * 
 * Input: 10
 * Output:
 * 1 2 7
 * 2 7 1
 * 7 1 2
 * 
 * Let's take row one -> 1 + 2 + 7 = 10
 * Let's take last column -> 7 + 1 + 2 = 10
 * 
 * Note: Output should be always be a 3*3 matrix pattern
 * Also sum of values of any row or any column should match the provided input
 * 
 */
import java.util.*;

class Matrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int val = input - 3;

        int[][] matrix = {
                { 1, 2, val },
                { 2, val, 1 },
                { val, 1, 2 }
        };

        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println("");
        }
        scanner.close();
    }
}