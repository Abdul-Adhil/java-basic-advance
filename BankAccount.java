
import java.util.Random;
import java.util.Scanner;

public class BankAccount {

    private long accNo;
    private String name;
    private double balance;
    private String pan;

    BankAccount() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter the Account holder name");
        name = scanner.nextLine();
        System.out.println("Enter the Customer PAN number");
        pan = scanner.nextLine();
        accNo = Math.abs(random.nextLong());
        balance = 0;
        System.out.println("");
    }

    public BankAccount(long accNo, double balance, String name, String pan) {
        this.accNo = accNo;
        this.balance = balance;
        this.name = name;
        this.pan = pan;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
  
        sb.append("accNo=").append(accNo);
        sb.append(", name=").append(name);
        sb.append(", balance=").append(balance);
        sb.append(", pan=").append(pan);
        return sb.toString();
    }

    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    

}
