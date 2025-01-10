/*
 * 
 * Write a program to print the following String pattern
 * Input: a3b10c4
 * Output: aaabbbbbbbbbbcccc
 * 
 */

import java.util.*;

class StringPattern2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = 0; i < input.length() - 1; i++) {

            String n = "";
            String chr = String.valueOf(input.charAt(i));

            while (i < input.length() - 1 && Character.isDigit(input.charAt(i + 1))) {
                n += input.charAt(i + 1);
                i++;
            }

            System.out.print(chr.repeat(Integer.parseInt(n)));
        }

        scanner.close();

    }
}