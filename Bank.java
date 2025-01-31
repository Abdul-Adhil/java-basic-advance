
import java.util.Scanner;

public class Bank {

    private String name;
    private int ifsc;

    public Bank(int ifsc, String name) {
        this.ifsc = ifsc;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIfsc() {
        return ifsc;
    }

    public void setIfsc(int ifsc) {
        this.ifsc = ifsc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bank{");
        sb.append("name=").append(name);
        sb.append(", ifsc=").append(ifsc);
        sb.append('}');
        return sb.toString();
    }

    public void addNewCustomer(String customerDetails) {
        new FileHandler(name + " Customer.txt").addCustomer(customerDetails);
    }

    public void findCustomer(String accNo) {

    }

    public void issueCreditCard(long accNo, BankAccount[] accounts) {

        boolean isAccountFound = false;

        for (BankAccount account : accounts) {
            if (account.getAccNo() == accNo) {
                isAccountFound = true;
                break;
            }
        }

        if (isAccountFound) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the Account Holder name");
            String cardHolder = scanner.nextLine();

            System.out.println("Enter the Card Number");
            int cardNo = scanner.nextInt();

            System.out.println("Enter the CVV");
            int cvv = scanner.nextInt();

            System.out.println("Enter the PIN");
            int pin = scanner.nextInt();

            System.out.println("Enter the balance");
            double balance = scanner.nextDouble();

            CreditCard cc = new CreditCard(accNo, balance, cardHolder, cardNo, cvv, pin, "active");

            new FileHandler(name + " credit cards.txt").addData(cc.toString());
        } else {
            System.out.println("Account not found..!!");
        }

    }
    

}
