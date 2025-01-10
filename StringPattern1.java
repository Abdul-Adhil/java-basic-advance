/*
 * 
 * 
 * Print the following String pattern
 * 
 * Input: sirius 2
 * Output: sius
 * 
 * Input: javadeveloper 3
 * output: javper
 * 
 * Input: laptop 1
 * output: lp
 * 
 */
import java.util.*;
class StringPattern1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] stringParts = input.split(" ");

        if (stringParts.length == 2) {

            String str = stringParts[0];
            int strLen = str.length();

            int n = Integer.parseInt(stringParts[1]);

            System.out.printf(str.substring(0, n) + str.substring(strLen - n, strLen));
        } else {
            System.out.print("Enter a valid format");
        }
        scanner.close();
    }
}
