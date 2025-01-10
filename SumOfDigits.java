/*
 * 
 * Find the sum of the digits with the given format
 * 
 * Input: 2520
 * Output: 72
 * 
 * In the above Examples take first and last digit and append it to form 20
 * Also take second digit from front and last and append it to form 52
 * Now add 52 + 20
 * 
 * Input: 17296
 * Output: 97
 * 
 * In the above split 16 + 79 + 2 = 97
 * 
 * Note: Use Functions to Code this problem
 * 
 */

import java.util.Scanner;

class SumOfDigits {
    static int stringToInteger(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] arr = input.split("");

        int strLen = arr.length;

        int sum = 0;

        int loopCondition = strLen / 2 + strLen % 2;

        for (int i = 0; i < loopCondition; i++) {

            if (i == strLen - 1 - i) {
                sum += stringToInteger(arr[i]);
                break;
            }
            sum += stringToInteger(arr[i] + arr[strLen - 1 - i]);
        }

        System.out.print(sum);
        scanner.close();
    }

}
