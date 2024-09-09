/*
 * 
 * 1. Write a program using switch case to create a Calculator

        Input: add 5 10
        Output: 15

        Input: multiply 2 7
        Output: 14
 */

class Calculator {
    public static void main(String[] args) {

        int a, b;

        String opertaion = "muliply";
        a = 15;
        b = 10;

        switch (opertaion) {
            case "add":
                System.out.println(a + b);
                break;
            case "multiply":
                System.out.println(a * b);
                break;
            default:
                System.out.println("Enter a valid operation!!");
        }
    }
}