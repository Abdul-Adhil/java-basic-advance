/*
 * 
 *  Write a Java program to Find if a given number is Armstrong number or Not
 * Input : 153
 * Output : Armstrong
 * 
 * Input: 57
 * Output: Not an Armstrong Number
 * 
 * Note: A number is thought of as an Armstrong number if the sum of its own
 * digits raised to the power number of digits gives the number itself. For
 * example, 0, 1, 153, 370, 371, 407 are three-digit Armstrong numbers and,
 * 1634, 8208, 9474 are four-digit Armstrong numbers and there are many more
 * 
 */

class ArmstrongNumber {
    public static void main(String[] args) {
        int input = 153;

        int sum = 0;
        int temp = input;
        int countTemp = input;
        int count = 0;

        while (countTemp != 0) {
            countTemp = countTemp / 10;
            count++;
        }

        while (temp != 0) {
            int r = temp % 10;
            int multipleValue = 1;

            for (int i = 0; i < count; i++) {
                multipleValue = r * multipleValue;
            }

            sum += multipleValue;
            temp = temp / 10;

        }

        if (input == sum) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }

    }
}