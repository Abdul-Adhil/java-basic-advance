/*
 * Write a program to print all the Prime Numbers within a given Range
    Input: 1 10
    Output: 2 3 5 7
 */

class  PrimeNumbers{
    public static void main(String[] args) {
        /* code */
        for (int i = 1; i <= 10; i++) {
            if (i == 1)
                continue;

            int flag = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0)
                System.out.print(i);

        }

    }
}