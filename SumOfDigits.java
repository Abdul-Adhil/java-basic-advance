/*
 * 
 * 1. Write a program using While loop to find the sum of digits of a given number till it reaches single digit

    Input: 18257
    Output: 5

    Note: Sum of 1+8+2+5+7 is 23 and again sum of 2 + 3 is 5 //Result
 */

class SumOfDigits {
    public static void main(String[] args) {

        int input = 18257;
        int sum = 0;

        while (input != 0 || sum > 9) {

            if (input == 0) {
                input = sum;
                sum = 0;
            }

            sum += input % 10;
            input = input / 10;

        }
        System.out.println(sum);
    }
}