/*
 * 
 * Find the final product of the given number till it reaches one digit
 * Input: 347
 * Output: 6
 * 
 * 347 -> 3*4*7 = 84 -> 8*4 -> 32 -> 3*2 -> 6
 * Stop the program when it becomes single digit product
 * Note: Use Recursion to solve this problem
 * 
 */
import java.util.Scanner;

class Recursion {

    static int multiplyNum(int n) {

        if (n >= 0 & n <= 9) {
            return n;
        } else {
            int temp = n;
            int calVal = 1;

            while (temp > 0) {
                calVal *= temp % 10;
                temp = temp / 10;
            }
            return multiplyNum(calVal);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int finalProduct = multiplyNum(input);

        System.out.print(finalProduct);
        scanner.close();
    }
}