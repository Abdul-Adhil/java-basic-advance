
import java.util.Objects;
import java.util.Scanner;
import utils.Array;

public class CreditCardManagement {

    public static void main(String[] args) {

        System.out.println("Welcome to the App");

        Customer[] customers = new Customer[100];

        Bank bank1 = new Bank(1234, "Bank A");
        Array arr = new Array();


        int userPreference = 1;

        while (userPreference != 3) {
            System.out.println("1. Start");
            System.out.println("2. Add User");
            System.out.println("3. Cancel");
            Scanner scanner = new Scanner(System.in);
            userPreference = scanner.nextInt();
            System.out.println("");

            if (userPreference == 1) {
                System.out.println("Select the user type");
                System.out.println("1. Bank Administrator\n2. Customer");
                int userType = scanner.nextInt();
                System.out.println("");

                switch (userType) {
                    case 1:
                        System.out.println("1. View All Customer data");
                        System.out.println("2. Add new Customer");
                        System.out.println("3. Issue credit card");
                        int adminPreference = scanner.nextInt();
                        System.out.println("");
                        switch (adminPreference) {
                            case 1:
                                new FileHandler(bank1.getName() + " Customer.txt").displayContent();
                                break;
                            case 2:
                                BankAccount ba = new BankAccount();
                                bank1.addNewCustomer(ba.toString());
                                break;
                            case 3:
                                System.out.println("Enter the Account Number");
                                long accNo = scanner.nextLong();

                                BankAccount[] accounts = new FileHandler("Bank A Customer.txt").getFileContent();

                                bank1.issueCreditCard(accNo, accounts);

                                break;

                            default:
                                System.out.println("Please select a valid option");
                        }
                        break;
                    case 2:
                        System.out.println("1. Add Account");
                        System.out.println("2. View Card balance");
                        System.out.println("3. Deposit");
                        System.out.println("4. Close/block credit card");

                        int customerPreference = scanner.nextInt();
                        CreditCard card;
                        switch (customerPreference) {
                            case 1:
                                System.out.println("Enter your Bank Account number");
                                long accNo = scanner.nextLong();
                                System.out.println("Enter your Bank PAN number");
                                String pan = scanner.next();
                                Customer c = new Customer(pan);
                                c.addAccount(accNo, bank1.getName() + " Customer.txt", pan);

                                break;

                            case 2:

                                System.out.println("Enter your Bank Account Number");
                                long accountNo = scanner.nextLong();

                                card = new CreditCard();
                                CreditCard[] listOfcards = card.fetchCreditCards(bank1.getName(), accountNo);
                                System.out.println("");
                                int length = arr.arrayLength(listOfcards);
                                if(length>0){
                                    System.out.println("Select the card to view the balance");
                                    int cardChoise = scanner.nextInt();
                                    System.out.println("");
                                    System.out.println("Enter your PIN");
                                    int pin = scanner.nextInt();
                                    if (listOfcards[cardChoise - 1].validatePIN(pin)) {
                                        if(Objects.equals(listOfcards[cardChoise - 1].getStatus(), "active"))
                                            System.out.println(String.format("You can spend up to %.2f this month!", listOfcards[cardChoise - 1].getBalance()));
                                        else
                                            System.out.println("Your card is inActive. Please contact Bank for further queries");
                                    } else {
                                        System.out.println("Enter a valid PIN");
                                    }
                                }else{
                                    System.out.println("No Card Found..!!");
                                }


                                break;

                            case 3:

                                System.out.println("Enter your Card Number");
                                int cardNo = scanner.nextInt();
                                card = new CreditCard();
                                CreditCard[] cardsArr = card.fetchCreditCards(bank1.getName());
                                boolean isDeposit = card.deposit(cardsArr, cardNo, bank1.getName());

                                if (!isDeposit) {
                                    System.out.println("Deposit failed!! Please try again after sometimes");
                                } else {
                                    System.out.println("Deposit Successful..!!");
                                }

                                break;

                            case 4:
                                System.out.println("Enter your Card No");
                                int blockCardNo = scanner.nextInt();
                                card = new CreditCard();
                                CreditCard[] cardsArray = card.fetchCreditCards(bank1.getName());
                                boolean isBlocked = card.blockCreditCard(cardsArray,blockCardNo,bank1.getName());

                                if(isBlocked){
                                    System.out.println("Card blocked Successful..!!");
                                }else {
                                    System.out.println("Card block has been failed. Please contact the Bank for further queries..!!");
                                }

                                break;
                            default:
                                System.out.println("Please select a valid option");
                        }

                        break;
                    default:
                        System.out.println("Choose a valid option");
                        break;
                }
            }

            if (userPreference == 2) {

                Customer c = new Customer();
                new FileHandler("customer.txt").addCustomer(c.toString());
            }

            System.out.println("");
        }

    }
}
