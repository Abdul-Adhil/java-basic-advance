
import java.util.Scanner;

public class Customer {

    private String name;
    private int age;
    private int creditCardCount;
    private String bankAccounts;
    private String pan;

    Customer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the customer name");
        name = scanner.nextLine();
        System.out.println("Enter the customer age");
        age = scanner.nextInt();
        System.out.println("Enter the customer PAN");
        pan = scanner.next();
        System.out.println("");
        bankAccounts="";

    }

    public Customer(String name, int age, String bankAccounts, int creditCardCount, String pan) {

        this.age = age;
        this.bankAccounts = bankAccounts;
        this.name = name;
        this.pan = pan;
        this.creditCardCount = creditCardCount;
    }

    public Customer(String pan) {
        this.pan = pan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(String bankAccounts) {
        this.bankAccounts = this.bankAccounts + bankAccounts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", creditCardCount=").append(creditCardCount);
        sb.append(", pan=").append(pan);
        sb.append(", accounts=").append(bankAccounts);

        return sb.toString();
    }

    public void addAccount(long accNo, String bankName, String pan) {

        BankAccount[] accounts = new FileHandler(bankName).getFileContent();

        boolean isAccountFound = false;

        for (BankAccount account : accounts) {
            if (account.getAccNo() == accNo) {
                isAccountFound = true;
                break;
            }
        }

        if (isAccountFound) {

            Customer[] customers = new FileHandler("customer.txt").getCustomerData();
            for (Customer customer : customers) {
                System.out.println(customer.getPan() + "" + pan);
                if (customer.getPan().equals(pan)) {

                    customer.setBankAccounts(accNo + ":");
                    System.out.println(customer.getBankAccounts());
                    break;
                }
            }
            new FileHandler("customer.txt").replaceCustomerData(customers);
        } else {
            System.out.println("Account not found..!!");
        }

    }

}
